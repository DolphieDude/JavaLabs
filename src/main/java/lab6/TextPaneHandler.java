package lab6;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

class TextPaneHandler {
    private final JTextPane textPane;

    public TextPaneHandler(JTextPane textPane) {
        this.textPane = textPane;
    }

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


    public void setText(String text) {
        textPane.setText(text);
    }

    public String getText() {
        return textPane.getText();
    }
}
