package com.example.langbot.service;

import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class A1A21 {
    int a;int b;
    public void A1A2ENG1(long chatId, long messageId)
    {
        a = 0;
        b = 0;
        String text = "Выберите правильный ответ в этом диалоге. Hello! I’m Susanna. What’s your name?";
        EditMessageText message = new EditMessageText();

        message.setChatId(String.valueOf(chatId));
        message.setText(text);
        message.setMessageId((int) messageId);
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();

        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();

        List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline4 = new ArrayList<>();

        List<InlineKeyboardButton> rowInline5 = new ArrayList<>();
        var A1A2ENG11button = new InlineKeyboardButton();
        A1A2ENG11button.setText("I do Anna");
        A1A2ENG11button.setCallbackData("A1A2ENG11_BUTTON"); // Английский язык первая цифра - первое слово, вторая цифра первый вариант перевода
        var A1A2ENG12button = new InlineKeyboardButton();
        A1A2ENG12button.setText("My name Anna");
        A1A2ENG12button.setCallbackData("A1A2ENG12_BUTTON");
        var A1A2ENG13button = new InlineKeyboardButton();
        A1A2ENG13button.setText("My name is Anna");
        A1A2ENG13button.setCallbackData("A1A2ENG13_BUTTON");

        var BACKLANGbutton = new InlineKeyboardButton();
        BACKLANGbutton.setText("Вернуться к выбору языка");
        BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
        var BACKLEVELENGbutton = new InlineKeyboardButton();
        BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
        BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

        rowInline1.add(A1A2ENG11button);
        rowInline2.add(A1A2ENG12button);
        rowInline3.add(A1A2ENG13button);
        rowInline4.add(BACKLANGbutton);
        rowInline5.add(BACKLEVELENGbutton);
        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2);
        rowsInline.add(rowInline3);
        rowsInline.add(rowInline4);
        rowsInline.add(rowInline5);
        markupInline.setKeyboard(rowsInline);
        message.setReplyMarkup(markupInline);
        // exe(message);
    }

}
