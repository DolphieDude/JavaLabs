package lab6;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * The TextPaneHandler class provides methods to handle text styling in a JTextPane.
 */
class TextPaneHandler {
    private final JTextPane textPane;

    /**
     * Constructs a TextPaneHandler with a JTextPane to handle.
     *
     * @param textPane the JTextPane to handle
     */
    public TextPaneHandler(JTextPane textPane) {
        this.textPane = textPane;
    }

    /**
     * Sets the style of the text at the caret position in the JTextPane.
     *
     * @param style the style to set ("Bold" or "Italic")
     */
    public void setPaneStyle(String style) {
        StyledDocument doc = textPane.getStyledDocument();
        int caretPosition = textPane.getCaretPosition();

        SimpleAttributeSet styleAttrs = new SimpleAttributeSet();

        if (caretPosition < doc.getLength()) {
            styleAttrs = new SimpleAttributeSet(doc.getCharacterElement(caretPosition).getAttributes());
        } else if (caretPosition > 0) {
            styleAttrs = new SimpleAttributeSet(doc.getCharacterElement(caretPosition - 1).getAttributes());
        }

        StyleConstants.setBold(styleAttrs, false);
        StyleConstants.setItalic(styleAttrs, false);

        switch (style.toLowerCase()) {
            case "bold":
                StyleConstants.setBold(styleAttrs, true);
                break;
            case "italic":
                StyleConstants.setItalic(styleAttrs, true);
                break;
        }

        if (caretPosition < doc.getLength()) {
            doc.setCharacterAttributes(caretPosition, 1, styleAttrs, false);
        } else {
            textPane.setCharacterAttributes(styleAttrs, true);
        }
    }

    /**
     * Sets the font size of the text at the caret position in the JTextPane.
     *
     * @param size the font size to set (e.g., "10pt", "12pt")
     */
    public void setPaneSize(String size) {
        int fontSize = Integer.parseInt(size.replaceAll("[^\\d.]", ""));

        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet existingAttrs = new SimpleAttributeSet();
        int caretPosition = textPane.getCaretPosition();
        AttributeSet currentAttrs = textPane.getCharacterAttributes();

        if (caretPosition < doc.getLength()) {
            existingAttrs = new SimpleAttributeSet(doc.getCharacterElement(caretPosition).getAttributes());
        } else if (caretPosition > 0) {
            existingAttrs = new SimpleAttributeSet(doc.getCharacterElement(caretPosition - 1).getAttributes());
        }

        existingAttrs.addAttribute(StyleConstants.FontSize, fontSize);

        if (StyleConstants.isBold(currentAttrs)) {
            existingAttrs.addAttribute(StyleConstants.Bold, true);
        }

        if (StyleConstants.isItalic(currentAttrs)) {
            existingAttrs.addAttribute(StyleConstants.Italic, true);
        }

        if (caretPosition < doc.getLength()) {
            doc.setCharacterAttributes(caretPosition, 1, existingAttrs, false);
        } else {
            textPane.setCharacterAttributes(existingAttrs, true);
        }
    }

    /**
     * Sets the text of the JTextPane.
     *
     * @param text the text to set
     */
    public void setText(String text) {
        textPane.setText(text);
    }

    /**
     * Gets the text from the JTextPane.
     *
     * @return the text in the JTextPane
     */
    public String getText() {
        return textPane.getText();
    }
}
