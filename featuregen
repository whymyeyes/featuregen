#!/bin/sh

BUFFER=""
DEFAULT_TEMPLATE="featuregen/default.featuregen"
FEATUREGEN_VERSION="1.0.00"
FILE_PATH=""
IN_FILE=0
VARS_STORAGE=""
VAR_PREFIX="~<<"
VAR_SUFFIX=">>"

#--------------------------{ TEMPLATE SELECTION }-----------------------------------------------------------------------

if [ -f "$1" ]; then
    FILE="$1"
    shift
elif [ -f "$DEFAULT_TEMPLATE" ]; then
    FILE="$DEFAULT_TEMPLATE"
else
    if [ -z "$1" ]; then
        echo "ERROR: No template file provided and default '$DEFAULT_TEMPLATE' not found."
    else
        echo "ERROR: Template file '$1' not found and default '$DEFAULT_TEMPLATE' also missing."
    fi
    exit 1
fi

#--------------------------{ CORE FUNCTIONS }---------------------------------------------------------------------------

# Stores or updates a variable in the global VARS_STORAGE key-value store.
# Logic:
# 1. Removes any existing entry with the same key
# 2. Appends the new key=value pair to storage
#
# Example:
#   set_var "name" "Neo"
set_var() {
  VARS_STORAGE=$(printf "%s\n" "$VARS_STORAGE" | grep -v "^$1=")
  VARS_STORAGE="$VARS_STORAGE
$1=$2"
}

# Retrieves a variable value from VARS_STORAGE by key.
# Logic:
# 1. Finds the line starting with key=
# 2. Extracts and returns the value part
#
# Example:
#   get_var "name" -> "Neo"
get_var() {
  printf "%s\n" "$VARS_STORAGE" | grep "^$1=" | cut -d= -f2-
}

# Shortcut alias for get_var, used for template expressions.
#
# Example:
#   get "Neo"
get() {
  get_var "$1"
}

# Applies variable substitution inside a template line.
# Logic:
# 1. Iterates over all key=value pairs in VARS_STORAGE
# 2. Escapes special characters for safe sed usage
# 3. Replaces occurrences of [key] with its value in the input line
#
# Example:
#   "Wake Up, ~<<name>>" -> "Wake Up, Neo"
apply_vars() {
  line="$1"

  while IFS='=' read -r k v; do
    [ -z "$k" ] && continue

    safeK=$(printf "%s" "$k" | sed 's/[.[\*^$/\\]/\\&/g')
    safeV=$(printf "%s" "$v" | sed 's/[|&\\]/\\&/g')
    line=$(printf "%s" "$line" | sed "s|$VAR_PREFIX$safeK$VAR_SUFFIX|$safeV|g")

  done <<EOF
$VARS_STORAGE
EOF
  printf "%s" "$line"
}

# Trims leading/trailing whitespace and removes carriage return characters.
# Used to normalize raw input lines before processing.
#
# Example:
#   "  hello \r " -> "hello"
trim() {
  printf "%s" "$1" | tr -d '\r' | sed 's/^[[:space:]]*//;s/[[:space:]]*$//'
}

# Cleans directive lines by removing unnecessary leading whitespace.
# Intended for preprocessing template directives like @let, @file, @expect.
clean_if_directive() {
  case "$1" in
    *"@let"*)
      printf "%s" "$1" | sed 's/^[[:space:]]*//'
      ;;
    *"@file"*)
      printf "%s" "$1" | sed 's/^[[:space:]]*//'
      ;;
    *"@expect"*)
      printf "%s" "$1" | sed 's/^[[:space:]]*//'
      ;;
    "@@fstart"|~"@@fend")
      printf "%s" "$1"
      ;;
    *)
      printf "%s" "$1"
      ;;
  esac
}

#--------------------------{ INPUT PARSING }----------------------------------------------------------------------------

for arg in "$@"; do
  key=${arg%%=*}
  val=${arg#*=}
  set_var "$key" "$val"
done

#--------------------------{ TEMPLATE LANGUAGE FUNCTIONS }--------------------------------------------------------------

# Converts Snake_Case, PascalCase, or space-separated strings to camelCase.
# Logic:
# 1. Replaces spaces and underscores with newlines to process words individually.
# 2. Lowercases the first word.
# 3. Capitalizes the first letter of all subsequent words.
# 4. Joins everything back into a single string.
#
# Supports:
# - snake_case
# - spaces
# - PascalCase
#
# NOT acronym-aware
#
# EXAMPLES:
#   "SimpleCase"          -> "simpleCase"
#   "may_the_force"       -> "mayTheForce"
#   "With Spaces"         -> "withSpaces"
#   "alreadyCamel"        -> "alreadyCamel"
#   "JSON_parser"         -> "jsonParser"
camel() {
  printf "%s" "$1" | awk '
  {
    s = $0

    # normalize separators
    gsub(/[-_]+/, " ", s)

    out = ""
    prevLower = 0

    for (i = 1; i <= length(s); i++) {
      c = substr(s, i, 1)

      if (c ~ /[A-Z]/ && prevLower) {
        out = out " "
      }

      out = out c
      prevLower = (c ~ /[a-z0-9]/)
    }

    n = split(out, words, /[ ]+/)

    result = ""

    for (i = 1; i <= n; i++) {
      w = tolower(words[i])

      if (i == 1) {
        result = w
      } else {
        result = result toupper(substr(w,1,1)) substr(w,2)
      }
    }

    printf "%s", result
  }'
}

# Removes substring from string ignoring case.
# Logic:
# 1. Uses awk's gsub with a case-insensitive regex.
#
# EXAMPLES:
#   "Hello World" "hello" -> " World"
#   "User_ID" "_id"       -> "User"
extractIgnoringCase() {
  val="$1"
  rem="$2"

  printf "%s" "$val" | awk -v rem="$rem" '
  {
    rem_lower = tolower(rem)

    while (match(tolower($0), rem_lower)) {
      $0 = substr($0, 1, RSTART-1) substr($0, RSTART+RLENGTH)
    }
    print
  }'
}

# Converts a dot-separated package name to a file system path.
# Logic:
# 1. Replaces all dots with forward slashes.
# 2. Preserves existing underscores and digits (important for Android/Kotlin packages).
#
# EXAMPLES:
#   "single"                 -> "single"
#   "com.example.app"        -> "com/example/app"
#   "com.example.v2_feature" -> "com/example/v2_feature" (Preserves underscores/digits)
pathFromPackage() {
  printf "%s" "$1" | tr '.' '/'
}

# Converts CamelCase, PascalCase, or space-separated strings to snake_case.
# Logic:
# 1. Replaces spaces with underscores.
# 2. Inserts an underscore before every uppercase letter.
# 3. Collapses multiple consecutive underscores (prevents "__" if "_" already existed).
# 4. Removes leading underscores.
# 5. Removes trailing underscores.
# 6. Converts the entire result to lowercase.
#
# EXAMPLES:
#   "SimpleCase"          -> "simple_case"           (Standard PascalCase)
#   "mayTheForce"         -> "may_the_force"         (Standard camelCase)
#   "already_snake"       -> "already_snake"         (Corner case: existing "_")
#   "Already_Snake"       -> "already_snake"         (Corner case: existing "_")
#   "Double__Underscore"  -> "double_underscore"     (Corner case: collapsed "__")
#   "With Spaces"         -> "with_spaces"           (Corner case: space handling)
#   "JSONParser"          -> "json_parser"           (Corner case: abbreviations)
#   "__StartEnd__"        -> "start_end"             (Edge cleaning)
snake() {
  printf "%s" "$1" | \
    tr ' ' '_' | \
    sed -E 's/([A-Z]+)([A-Z][a-z])/\1_\2/g' | \
    sed -E 's/([a-z0-9])([A-Z])/\1_\2/g' | \
    sed 's/___*/_/g' | \
    sed 's/^_//' | \
    sed 's/_$//' | \
    tr '[:upper:]' '[:lower:]'
}

# Converts CamelCase, PascalCase, or space-separated strings to SCREAMING_SNAKE_CASE.
# Logic:
# 1. Replaces spaces with underscores.
# 2. Inserts an underscore before every uppercase letter.
# 3. Collapses multiple consecutive underscores (prevents "__" if "_" already existed).
# 4. Removes leading underscores.
# 5. Removes trailing underscores.
# 6. Converts the entire result to uppercase.
#
# EXAMPLES:
#   "SimpleCase"          -> "SIMPLE_CASE"           (Standard PascalCase)
#   "mayTheForce"         -> "MAY_THE_FORCE"         (Standard camelCase)
#   "already_snake"       -> "ALREADY_SNAKE"         (Corner case: existing "_")
#   "Already_Snake"       -> "ALREADY_SNAKE"         (Corner case: existing "_")
#   "Double__Underscore"  -> "DOUBLE_UNDERSCORE"     (Corner case: collapsed "__")
#   "With Spaces"         -> "WITH_SPACES"           (Corner case: space handling)
#   "JSONParser"          -> "JSON_PARSER"           (Corner case: abbreviations)
#   "__StartEnd__"        -> "START_END"             (Edge cleaning)
screamingSnake() {
  snake "$1" | tr '[:lower:]' '[:upper:]'
}

#--------------------------{ EXECUTION ENGINE }-------------------------------------------------------------------------

process() {
  token=$(clean_if_directive "$token")
  trimmedToken=$(trim "$token")

  # -------------------------
  # COMMENT
  # -------------------------
  if [ "$IN_FILE" -eq 0 ]; then
    case "$trimmedToken" in
      '//'*)
        return
        ;;
    esac
  fi

  # -------------------------
  # EXPECT
  # -------------------------
  case "$token" in
    @expect*)
      key=${token#@expect }
      key=$(trim "$key")

      val=$(get "$key")
      if [ -z "$val" ]; then
        echo "ERROR: missing required variable: $key"
        exit 1
      fi
      ;;

    # -------------------------
    # LET
    # -------------------------
    @let*)
      expr=${token#@let }

      key=${expr%%=*}
      val=${expr#*=}

      key=$(trim "$key")
      val=$(trim "$val")

      func=${val%%(*}
      args=${val#*(}
      args=${args%)*}

      func=$(trim "$func")
      args=$(trim "$args")

      if echo "$args" | grep -q ","; then
        a1=${args%%,*}
        a2=${args#*,}
      else
        a1="$args"
        a2=""
      fi

      a1=$(trim "$a1")
      a2=$(trim "$a2")

      v1=$(get "$a1")
      [ -z "$v1" ] && v1="$a1"

      case "$func" in
        extractIgnoringCase)
          result=$(extractIgnoringCase "$v1" "$a2")
          ;;
        snake)
          result=$(snake "$v1")
          ;;
        screamingSnake)
          result=$(screamingSnake "$v1")
          ;;
        camel)
          result=$(camel "$v1")
          ;;
        pathFromPackage)
          result=$(pathFromPackage "$v1")
          ;;
        featuregenVersion)
            result="$FEATUREGEN_VERSION"
            ;;
        *)
          echo "ERROR: unknown function: $func"
          exit 1
          ;;
      esac

     # @let packagePath = pathFromPackage(package)
      set_var "$key" "$result"
      ;;

    # -------------------------
    # FILE DECL
    # -------------------------
    @file*)
      FILE_PATH=${token#@file path=}

      while IFS='=' read -r k v; do
        [ -z "$k" ] && continue

        safeK=$(printf "%s" "$k" | sed 's/[.[\*^$/\\]/\\&/g')
        safeV=$(printf "%s" "$v" | sed 's/[|&\\]/\\&/g')

        FILE_PATH=$(printf "%s" "$FILE_PATH" | sed "s|$VAR_PREFIX$safeK$VAR_SUFFIX|$safeV|g")
      done <<EOF
$VARS_STORAGE
EOF
      ;;

    # -------------------------
    # FILE BLOCK START
    # -------------------------
    "@@fstart")
      IN_FILE=1
      BUFFER=""
      ;;

    # -------------------------
    # FILE BLOCK END
    # -------------------------
    "@@fend")
      IN_FILE=0

      if [ -z "$FILE_PATH" ]; then
        echo "ERROR: FILE_PATH is not defined. Ensure @file path=... is set before fend."
        exit 1
      fi

      # Create directory if it doesn't exist
      mkdir -p "$(dirname "$FILE_PATH")"

      # Write the buffer to the file.
      printf "%s" "$BUFFER" > "$FILE_PATH"

      echo "CREATED: $FILE_PATH"

      BUFFER=""
      FILE_PATH=""
      ;;

    # -------------------------
    # CONTENT
    # -------------------------
    *)
      if [ "$IN_FILE" -eq 1 ]; then
        processedLine=$(apply_vars "$token")

        if [ -z "$BUFFER" ]; then
          BUFFER="$processedLine"
        else
          BUFFER="${BUFFER}
${processedLine}"
        fi
      fi
      ;;
  esac
}

#--------------------------{ MAIN LOOP (LEXER STREAM) }-----------------------------------------------------------------

tokenize() {
    raw="$1"

    raw=$(printf "%s" "$raw" | tr -d '\r')

    case "$raw" in
        @*|~*)
            trim "$raw"
            ;;
        *)
            printf "%s" "$raw"
            ;;
    esac
}

while IFS= read -r raw || [ -n "$raw" ]; do
    token=$(tokenize "$raw")
    process "$token"
done < "$FILE"

if [ "$IN_FILE" -eq 1 ]; then
  echo "ERROR: missing @@fend (unclosed file block)"
  exit 1
fi