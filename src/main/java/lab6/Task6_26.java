package lab6;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class Task6_26 extends JFrame {
    private final TextPaneHandler textPaneHandler;

    public Task6_26() {
        setTitle("Task6_26");
        setSize(1920, 1080);
        setLayout(new BorderLayout());

        JTextPane textPane = new JTextPane();
        textPaneHandler = new TextPaneHandler(textPane);

        Label styleLabel = new Label("Style:");
        Choice styleChoice = new Choice();
        styleChoice.add("Plain");
        styleChoice.add("Bold");
        styleChoice.add("Italic");
        styleChoice.select(0);

        Label sizeLabel = new Label("Size:");
        Choice sizeChoice = new Choice();
        sizeChoice.add("10pt");
        sizeChoice.add("12pt");
        sizeChoice.add("14pt");
        sizeChoice.select(1);

        styleChoice.addItemListener(e -> textPaneHandler.setPaneStyle(styleChoice.getSelectedItem()));
        sizeChoice.addItemListener(e -> textPaneHandler.setPaneSize(sizeChoice.getSelectedItem()));

        Panel fontPanel = new Panel();
        fontPanel.setLayout(new FlowLayout());
        fontPanel.add(styleLabel);
        fontPanel.add(styleChoice);
        fontPanel.add(sizeLabel);
        fontPanel.add(sizeChoice);

        add(fontPanel, BorderLayout.NORTH);
        add(new JScrollPane(textPane), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Task6_26::new);
    }
}

class TextPaneHandler {
    private final JTextPane textPane;

    public TextPaneHandler(JTextPane textPane) {
        this.textPane = textPane;
    }

    public void setPaneStyle(String style) {
        StyledDocument doc = textPane.getStyledDocument();
        int caretPosition = textPane.getCaretPosition();

        SimpleAttributeSet styleAttrs = new SimpleAttributeSet();

        // Retrieve existing attributes at the caret position
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

