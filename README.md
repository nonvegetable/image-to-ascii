# Image to ASCII Art Converter

A Java application that converts images into colorized ASCII art displayed in the terminal.

## Features

- Converts any image format supported by Java ImageIO (JPEG, PNG, GIF, BMP) to ASCII art
- Maintains aspect ratio during conversion
- Uses true color (24-bit RGB) ANSI escape codes for colorized output
- Resizes images to fit terminal width (100 characters)
- Uses brightness-based character mapping for realistic representation

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- A terminal that supports ANSI true color escape codes

## Building the Project

Clone or download the project, then build using Maven:

```bash
mvn clean package
```

This will create an executable JAR file in the `target` directory: `image-to-ascii-1.0-SNAPSHOT.jar`

## Usage

Run the application with an image path as argument:

```bash
java -jar target/image-to-ascii-1.0-SNAPSHOT.jar path/to/your/image.jpg
```

### Example

```bash
java -jar target/image-to-ascii-1.0-SNAPSHOT.jar photo.png
```

The application will:
1. Load the image
2. Display the original dimensions
3. Resize it to 100 characters width
4. Convert each pixel to a corresponding ASCII character based on brightness
5. Display the colorized ASCII art in your terminal

## How It Works

The converter uses a brightness ramp of ASCII characters ordered from darkest to brightest:

```
.'^,:;Il!i><~+_-?][}{1)(|\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$
```

Each pixel is:
1. Analyzed for brightness using the formula: `0.299*R + 0.587*G + 0.114*B`
2. Mapped to an appropriate character from the ramp
3. Colored using ANSI escape codes with the original RGB values

The vertical scaling factor (0.5) compensates for the typical character height-to-width ratio in terminals.

## Project Structure

```
image-to-ascii/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── mycompany/
│   │               └── app/
│   │                   └── App.java
│   └── test/
│       └── java/
│           └── com/
│               └── mycompany/
│                   └── app/
│                       └── AppTest.java
└── README.md
```

## Error Handling

The application handles common errors:
- Missing image path argument
- Invalid or non-existent file path
- Unsupported image format

## Terminal Compatibility

For best results, use a terminal that supports:
- ANSI escape codes
- 24-bit true color (16.7 million colors)

Most modern terminals support this, including:
- iTerm2 (macOS)
- Windows Terminal
- GNOME Terminal
- Konsole
- VS Code integrated terminal

## Contributing

Feel free to submit issues, fork the repository, and create pull requests for any improvements.
