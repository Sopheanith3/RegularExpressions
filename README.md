# Regular Expression Validator - _Junit Testing_

## Overview
This project implements regular expressions to validate various types of data, including Social Security Numbers, phone numbers, emails, names, dates, addresses, and more. Each validation function uses regular expressions, supplemented by additional logic where necessary. The project also includes unit tests to ensure correctness and edge case handling.

## Features
The following validations are implemented:

- **Social Security Number (SSN)**  
  Supports multiple formats (with dashes, spaces, or no spaces) and ensures validity based on SSA numbering rules.

- **US Phone Number**  
  Accepts numbers with optional parentheses and dashes, validating only official area codes.

- **Email Address**  
  Validates standard email formats.

- **Name on a Class Roster**  
  Supports names in the format 'Last, First MI'.

- **Date (MM-DD-YYYY or MM/DD/YYYY)**  
  Ensures valid dates, including leap years.

- **House Address**  
  Supports standard street numbers, names, and abbreviations for road types.

- **City, State, ZIP Code**  
  Ensures proper formatting, with state abbreviation validation.

- **Military Time**  
  Ensures valid 24-hour time format without colons.

- **US Currency**  
  Supports dollar amounts down to the penny, with commas where appropriate.

- **URL Validation**  
  Accepts 'http://' or 'https://', case-insensitive.

- **Password Validation**  
  Requires at least 10 characters, including uppercase, lowercase, digit, punctuation, and prevents more than three consecutive lowercase characters.

- **Odd-Length Words Ending in "ion"**  
  Matches words with an odd number of letters that end in "-ion".

## Installation

### Prerequisites
Ensure you have the following installed:
- Java Development Kit (JDK) 8+
- JUnit (for running unit tests)
- Git (for cloning the repository)

### Cloning the Repository
```sh
git clone https://github.com/yourusername/regex-validator.git
```
