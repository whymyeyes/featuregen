# Featuregen

Simple code generation without Python, Node.js, or external dependencies.

**Featuregen** is a tiny, dependency-free code generator written in POSIX shell.

It transforms template files into one or more source files using a small, purpose-built template language.

Need help creating a template? Use the optional AI-powered <a href="https://t.me/featuregen_bot" target="_blank" rel="noopener noreferrer">Telegram assistant</a> to generate a starting point.

The repository contains the Featuregen engine itself (implemented as a POSIX shell script) together with a comprehensive automated test suite written in Kotlin and JUnit, making the project easy to verify and extend.

## Features

- Zero dependencies
- POSIX shell compatible
- Multiple output files from a single template
- Built-in string transformation functions
- Simple and readable template language

---

# Example

Template:

```text
@expect package
@expect fullName

@let shortName = extractIgnoringCase(fullName, Feature)
@let snakeCaseName = snake(fullName)
@let packagePath = pathFromPackage(package)

@file path=~<<packagePath>>/~<<snakeCaseName>>/di/~<<shortName>>Module.kt
@@fstart
package ~<<package>>.~<<snakeCaseName>>.di

import ~<<package>>.~<<snakeCaseName>>.presentation.~<<shortName>>ViewModel

val ~<<shortName>>Module = module {

    viewModelOf(::~<<shortName>>ViewModel)
}
@@fend
```

Run:

```sh
./featuregen template.featuregen \
    package=foo.bar \
    fullName=FeatureLogin
```

Generated file:

```
foo/bar/feature_login/di/LoginModule.kt
```

Contents:

```kotlin
package foo.bar.feature_login.di

import foo.bar.feature_login.presentation.LoginViewModel

val LoginModule = module {

    viewModelOf(::LoginViewModel)
}
```

---

# Template Language

## @expect

Requires a variable to be provided.

```text
@expect package
```

Variables are passed as command-line arguments.

```sh
name=FeatureLogin
package=com.example.demo
```

Reference them using

```text
~<<name>>
```

Generation fails if the variable is missing.

---

## @let

Creates a new variable from a built-in function.

```text
@let packagePath = pathFromPackage(package)
```

---

## @file

Defines the destination file.

```text
@file path=src/~<<packagePath>>/Login.kt
```

---

## File Blocks

Everything between `@@fstart` and `@@fend` becomes the contents of a generated file.

```text
@@fstart
Hello
@@fend
```

---

## Built-in Functions

| Function | Description                                    |
|----------|------------------------------------------------|
| `camel(value)` | Converts text to camelCase                     |
| `snake(value)` | Converts text to snake_case                    |
| `screamingSnake(value)` | Converts text to SCREAMING_SNAKE_CASE          |
| `pathFromPackage(value)` | Converts `com.example.app` → `com/example/app` |
| `extractIgnoringCase(value, remove)` | Removes a substring ignoring case              |
| `featuregenVersion()` | Returns the current Featuregen version         |

---

## Comments

Lines starting with `//` outside file blocks are treated as comments and ignored by the generator.

```text
// This is a comment

@expect package

@file path=src/~<<packagePath>>/Example.kt

@@fstart
// This comment will be written to the generated file.
@@fend
```

Inside `@@fstart` and `@@fend`, every line—including those starting with `//`—is treated as file content.

---

# Template Assistant

FeatureGen includes an optional AI-powered Telegram assistant that helps you create `.featuregen` templates by describing the files and structure you want to generate.

Describe what you want to build, or provide a code snippet, and the bot will help you create the corresponding template.

Useful for:

- bootstrapping a ready-to-run Featuregen setup (script + template)
- creating new templates

➡️ Use the bot here: <a href="https://t.me/featuregen_bot" target="_blank" rel="noopener noreferrer">@featuregen_bot</a>

> Note: The bot is an external tool and is not required to use FeatureGen.

---


# License
[MIT License](LICENSE)