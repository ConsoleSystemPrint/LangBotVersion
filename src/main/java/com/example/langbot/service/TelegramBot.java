package com.example.langbot.service;


import com.example.langbot.config.BotConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
public class TelegramBot extends TelegramLongPollingBot
{
    @Autowired
    private final BotConfig config;
    public TelegramBot(BotConfig config) {this.config = config;}
    int a = 0; int b = 0; //A1A2 - eng
    int c = 0; int d = 0; //B1B2
    int i = 0; int f = 0; //C1C2

    int a1 = 0; int b1 = 0; // A1A2 - ger
    int c1 = 0; int d1 = 0;  //B1B2
    int  i1 = 0; int f1 = 0; // C1C2

    int a2 = 0; int b2 = 0; // A1A2 - fre
    int c2 = 0; int d2 = 0;  //B1B2
    int  i2 = 0; int f2 = 0; // C1C2
    @Override
    public String getBotUsername() {return config.getBotName();}
    @Override
    public String getBotToken() {return config.getToken();}
    @Override
    public void onUpdateReceived(Update update) //содержит информацию о том что присылается боту
    {


        if(update.hasMessage() && update.getMessage().hasText())
        {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            switch (messageText)
            {
                case "/start":

                    startCommandReceived(chatId, update.getMessage().getChat().getFirstName());

                    break;
                default: sendMessage(chatId, "Данная команда не поддерживается");
            }
        }
        if (update.hasCallbackQuery())
        {
            String callbackData = update.getCallbackQuery().getData();
            long messageId = update.getCallbackQuery().getMessage().getMessageId();
            long chatId = update.getCallbackQuery().getMessage().getChatId();
            if(callbackData.equals("ENG_BUTTON"))
            {
                String text = "Выбери тот уровень языка, на который, по твоему мнению, ты знаешь английский язык";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int)messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

                List<InlineKeyboardButton> rowInline1 = new ArrayList<>();

                List<InlineKeyboardButton> rowInline2 = new ArrayList<>();

                List<InlineKeyboardButton> rowInline3 = new ArrayList<>();

                var A1A2ENGbutton = new InlineKeyboardButton();
                A1A2ENGbutton.setText("Минимальный");
                A1A2ENGbutton.setCallbackData("A1A2ENG_BUTTON");
                var B1B2ENGbutton = new InlineKeyboardButton();
                B1B2ENGbutton.setText("Средний");
                B1B2ENGbutton.setCallbackData("B1B2ENG_BUTTON");
                var C1C2ENGbutton = new InlineKeyboardButton();
                C1C2ENGbutton.setText("Максимальный");
                C1C2ENGbutton.setCallbackData("C1C2ENG_BUTTON");
                rowInline1.add(A1A2ENGbutton);
                rowInline2.add(B1B2ENGbutton);
                rowInline3.add(C1C2ENGbutton);

                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2);
                rowsInline.add(rowInline3);
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("GER_BUTTON"))
            {
                String text = "Выбери тот уровень языка, на который, по твоему мнению, ты знаешь немецкий язык";
                EditMessageText message = new EditMessageText();
                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int)messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline1 = new ArrayList<>();

                List<InlineKeyboardButton> rowInline2 = new ArrayList<>();

                List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>();

                List<InlineKeyboardButton> rowInline5 = new ArrayList<>();
                var A1A2GERbutton = new InlineKeyboardButton();
                A1A2GERbutton.setText("Минимальный");
                A1A2GERbutton.setCallbackData("A1A2GER_BUTTON");
                var B1B2GERbutton = new InlineKeyboardButton();
                B1B2GERbutton.setText("Средний");
                B1B2GERbutton.setCallbackData("B1B2GER_BUTTON");
                var C1C2GERbutton = new InlineKeyboardButton();
                C1C2GERbutton.setText("Максимальный");
                C1C2GERbutton.setCallbackData("C1C2GER_BUTTON");
                rowInline1.add(A1A2GERbutton);
                rowInline2.add(B1B2GERbutton);
                rowInline3.add(C1C2GERbutton);
                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2);
                rowsInline.add(rowInline3);
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("FRE_BUTTON"))
            {

                String text = "Выбери тот уровень языка, на который, по твоему мнению, ты знаешь французский язык";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int)messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline1 = new ArrayList<>();

                List<InlineKeyboardButton> rowInline2 = new ArrayList<>();

                List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>();

                List<InlineKeyboardButton> rowInline5 = new ArrayList<>();
                var A1A2FREbutton = new InlineKeyboardButton();
                A1A2FREbutton.setText("Минимальный");
                A1A2FREbutton.setCallbackData("A1A2FRE_BUTTON");
                var B1B2FREbutton = new InlineKeyboardButton();
                B1B2FREbutton.setText("Средний");
                B1B2FREbutton.setCallbackData("B1B2FRE_BUTTON");
                var C1C2FREbutton = new InlineKeyboardButton();
                C1C2FREbutton.setText("Максимальный");
                C1C2FREbutton.setCallbackData("C1C2FRE_BUTTON");
                rowInline1.add(A1A2FREbutton);
                rowInline2.add(B1B2FREbutton);
                rowInline3.add(C1C2FREbutton);
                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2);
                rowsInline.add(rowInline3);
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("A1A2ENG_BUTTON"))
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
                exe(message);
            }
            if(callbackData.equals("A1A2ENG11_BUTTON") || callbackData.equals("A1A2ENG12_BUTTON") || callbackData.equals("A1A2ENG13_BUTTON"))
            {
                if(callbackData.equals("A1A2ENG13_BUTTON"))
                {
                    a += 1;
                }
                String text = "Выберите вариант ответа, который должен стоять на месте скобок. My sister's friend is (...) trained teacher.";
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
                var A1A2ENG21button = new InlineKeyboardButton();
                A1A2ENG21button.setText("the");
                A1A2ENG21button.setCallbackData("A1A2ENG21_BUTTON"); // Английский язык первая цифра - первое слово, вторая цифра первый вариант перевода
                var A1A2ENG22button = new InlineKeyboardButton();
                A1A2ENG22button.setText("a");
                A1A2ENG22button.setCallbackData("A1A2ENG22_BUTTON"); // правильный ответ
                var A1A2ENG23button = new InlineKeyboardButton();
                A1A2ENG23button.setText("an");
                A1A2ENG23button.setCallbackData("A1A2ENG23_BUTTON");

                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(A1A2ENG21button);
                rowInline2.add(A1A2ENG22button);
                rowInline3.add(A1A2ENG23button);
                rowInline4.add(BACKLANGbutton);
                rowInline5.add(BACKLEVELENGbutton);
                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2);
                rowsInline.add(rowInline3);
                rowsInline.add(rowInline4);
                rowsInline.add(rowInline5);
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }

            if(callbackData.equals("A1A2ENG21_BUTTON") || callbackData.equals("A1A2ENG22_BUTTON") || callbackData.equals("A1A2ENG23_BUTTON"))
            {
                if(callbackData.equals("A1A2ENG22_BUTTON"))
                {
                    b += 1;
                }
                String text = "Выберите вариант ответа, который должен стоять на месте скобок. My parents are rich. That’s (...) new house.";
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


                var A1A2ENG31button = new InlineKeyboardButton();
                A1A2ENG31button.setText("our"); // правильный ответ
                A1A2ENG31button.setCallbackData("A1A2ENG31_BUTTON"); // Английский язык первая цифра - первое слово, вторая цифра первый вариант перевода
                var A1A2ENG32button = new InlineKeyboardButton();
                A1A2ENG32button.setText("mine");
                A1A2ENG32button.setCallbackData("A1A2ENG32_BUTTON");
                var A1A2ENG33button = new InlineKeyboardButton();
                A1A2ENG33button.setText("theirs");
                A1A2ENG33button.setCallbackData("A1A2ENG33_BUTTON");

                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(A1A2ENG31button);
                rowInline2.add(A1A2ENG32button);
                rowInline3.add(A1A2ENG33button);
                rowInline4.add(BACKLANGbutton);
                rowInline5.add(BACKLEVELENGbutton);
                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2);
                rowsInline.add(rowInline3);
                rowsInline.add(rowInline4);
                rowsInline.add(rowInline5);
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("A1A2ENG31_BUTTON") || callbackData.equals("A1A2ENG32_BUTTON") || callbackData.equals("A1A2ENG33_BUTTON"))
            {
                if(callbackData.equals("A1A2ENG31_BUTTON"))
                {
                    a += 1;
                }
                String text = "Выберите вариант ответа, который должен стоять на месте скобок. This is the university (...) i studied economics.";
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


                var A1A2ENG41button = new InlineKeyboardButton();
                A1A2ENG41button.setText("when");
                A1A2ENG41button.setCallbackData("A1A2ENG41_BUTTON"); // Английский язык первая цифра - первое слово, вторая цифра первый вариант перевода
                var A1A2ENG42button = new InlineKeyboardButton();
                A1A2ENG42button.setText("where"); // правильный ответ
                A1A2ENG42button.setCallbackData("A1A2ENG42_BUTTON");
                var A1A2ENG43button = new InlineKeyboardButton();
                A1A2ENG43button.setText("who");
                A1A2ENG43button.setCallbackData("A1A2ENG43_BUTTON");

                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(A1A2ENG41button);
                rowInline2.add(A1A2ENG42button);
                rowInline3.add(A1A2ENG43button);
                rowInline4.add(BACKLANGbutton);
                rowInline5.add(BACKLEVELENGbutton);
                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2);
                rowsInline.add(rowInline3);
                rowsInline.add(rowInline4);
                rowsInline.add(rowInline5);
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("A1A2ENG41_BUTTON") || callbackData.equals("A1A2ENG42_BUTTON") || callbackData.equals("A1A2ENG43_BUTTON"))
            {
                if(callbackData.equals("A1A2ENG42_BUTTON"))
                {
                    b += 1;
                }
                if (a == b && a != 0 && b != 0)
                {
                    String text = "Выберите вариант ответа, который должен стоять на месте скобок. Where (...) you go on holiday last year?";
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


                    var A1A2ENG51button = new InlineKeyboardButton();
                    A1A2ENG51button.setText("do");
                    A1A2ENG51button.setCallbackData("A1A2ENG51_BUTTON"); // Английский язык первая цифра - первое слово, вторая цифра первый вариант перевода
                    var A1A2ENG52button = new InlineKeyboardButton();
                    A1A2ENG52button.setText("did"); // правильный ответ
                    A1A2ENG52button.setCallbackData("A1A2ENG52_BUTTON");
                    var A1A2ENG53button = new InlineKeyboardButton();
                    A1A2ENG53button.setText("were");
                    A1A2ENG53button.setCallbackData("A1A2ENG53_BUTTON");

                    var BACKLANGbutton = new InlineKeyboardButton();
                    BACKLANGbutton.setText("Вернуться к выбору языка");
                    BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                    var BACKLEVELENGbutton = new InlineKeyboardButton();
                    BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                    BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                    rowInline1.add(A1A2ENG51button);
                    rowInline2.add(A1A2ENG52button);
                    rowInline3.add(A1A2ENG53button);
                    rowInline4.add(BACKLANGbutton);
                    rowInline5.add(BACKLEVELENGbutton);
                    rowsInline.add(rowInline1);
                    rowsInline.add(rowInline2);
                    rowsInline.add(rowInline3);
                    rowsInline.add(rowInline4);
                    rowsInline.add(rowInline5);
                    markupInline.setKeyboard(rowsInline);
                    message.setReplyMarkup(markupInline);
                    exe(message);
                }
                if (a == 0 && b == 0)
                {
                    String text = "Вы ответили неправильно на все вопросы, рекомендую понизить уровень языка";
                    EditMessageText message = new EditMessageText();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(text);
                    message.setMessageId((int) messageId);
                    exe(message);
                }
                else
                {
                    if (a < b)
                    {
                        String text = "Ваш уровень владения английским языком соответствует уровню А2";
                        EditMessageText message = new EditMessageText();
                        message.setChatId(String.valueOf(chatId));
                        message.setText(text);
                        message.setMessageId((int) messageId);
                        exe(message);
                    }
                    if (a > b)
                    {
                        String text = "Ваш уровень владения английским языком соответствует уровню А1";
                        EditMessageText message = new EditMessageText();
                        message.setChatId(String.valueOf(chatId));
                        message.setText(text);
                        message.setMessageId((int) messageId);
                        exe(message);
                    }
                }
            }
            if(callbackData.equals("A1A2ENG51_BUTTON") || callbackData.equals("A1A2ENG53_BUTTON"))
            {
                String text = "Ваш уровень владения английским языком соответствует уровню А1";
                EditMessageText message = new EditMessageText();
                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                exe(message);
            }
            if(callbackData.equals("A1A2ENG52_BUTTON"))
            {
                String text = "Ваш уровень владения английским языком соответствует уровню А2";
                EditMessageText message = new EditMessageText();
                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                exe(message);
            }

















            if(callbackData.equals("B1B2ENG_BUTTON"))
            {
                c = 0;
                d = 0;
                String text = "Выберите вариант ответа, который должен стоять на месте скобок. Please let me (...) the book on the table.";
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
                var B1B2ENG11button = new InlineKeyboardButton();
                B1B2ENG11button.setText("put"); // правильный ответ
                B1B2ENG11button.setCallbackData("B1B2ENG11_BUTTON"); // Английский язык первая цифра - первое слово, вторая цифра первый вариант перевода
                var B1B2ENG12button = new InlineKeyboardButton();
                B1B2ENG12button.setText("to put");
                B1B2ENG12button.setCallbackData("B1B2ENG12_BUTTON");
                var B1B2ENG13button = new InlineKeyboardButton();
                B1B2ENG13button.setText("putting");
                B1B2ENG13button.setCallbackData("B1B2ENG13_BUTTON");

                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(B1B2ENG11button);
                rowInline2.add(B1B2ENG12button);
                rowInline3.add(B1B2ENG13button);
                rowInline4.add(BACKLANGbutton);
                rowInline5.add(BACKLEVELENGbutton);
                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2);
                rowsInline.add(rowInline3);
                rowsInline.add(rowInline4);
                rowsInline.add(rowInline5);
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("B1B2ENG11_BUTTON") || callbackData.equals("B1B2ENG12_BUTTON") || callbackData.equals("B1B2ENG13_BUTTON"))
            {
                if(callbackData.equals("B1B2ENG11_BUTTON"))
                {
                    c += 1;
                }
                String text = "Выберите вариант ответа, который должен стоять на месте скобок. She is interested (...) learning Spanish and French.";
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
                var B1B2ENG21button = new InlineKeyboardButton();
                B1B2ENG21button.setText("in"); // правильный ответ
                B1B2ENG21button.setCallbackData("B1B2ENG21_BUTTON"); // Английский язык первая цифра - первое слово, вторая цифра первый вариант перевода
                var B1B2ENG22button = new InlineKeyboardButton();
                B1B2ENG22button.setText("on");
                B1B2ENG22button.setCallbackData("B1B2ENG22_BUTTON");
                var B1B2ENG23button = new InlineKeyboardButton();
                B1B2ENG23button.setText("at");
                B1B2ENG23button.setCallbackData("B1B2ENG23_BUTTON");

                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(B1B2ENG21button);
                rowInline2.add(B1B2ENG22button);
                rowInline3.add(B1B2ENG23button);
                rowInline4.add(BACKLANGbutton);
                rowInline5.add(BACKLEVELENGbutton);
                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2);
                rowsInline.add(rowInline3);
                rowsInline.add(rowInline4);
                rowsInline.add(rowInline5);
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("B1B2ENG21_BUTTON") || callbackData.equals("B1B2ENG22_BUTTON") || callbackData.equals("B1B2ENG23_BUTTON"))
            {
                if(callbackData.equals("B1B2ENG21_BUTTON"))
                {
                    d += 1;
                }
                String text = "Выберите вариант ответа, который должен стоять на месте скобок.  I am excited (...) my new job next week.";
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


                var B1B2ENG31button = new InlineKeyboardButton();
                B1B2ENG31button.setText("start");
                B1B2ENG31button.setCallbackData("B1B2ENG31_BUTTON"); // Английский язык первая цифра - первое слово, вторая цифра первый вариант перевода
                var B1B2ENG32button = new InlineKeyboardButton();
                B1B2ENG32button.setText("to start");  // правильный ответ
                B1B2ENG32button.setCallbackData("B1B2ENG32_BUTTON");
                var B1B2ENG33button = new InlineKeyboardButton();
                B1B2ENG33button.setText("started");
                B1B2ENG33button.setCallbackData("B1B2ENG33_BUTTON");

                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(B1B2ENG31button);
                rowInline2.add(B1B2ENG32button);
                rowInline3.add(B1B2ENG33button);
                rowInline4.add(BACKLANGbutton);
                rowInline5.add(BACKLEVELENGbutton);
                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2);
                rowsInline.add(rowInline3);
                rowsInline.add(rowInline4);
                rowsInline.add(rowInline5);
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("B1B2ENG31_BUTTON") || callbackData.equals("B1B2ENG32_BUTTON") || callbackData.equals("B1B2ENG33_BUTTON"))
            {
                if(callbackData.equals("B1B2ENG32_BUTTON"))
                {
                    c += 1;
                }
                String text = "Выберите вариант ответа, который должен стоять на месте скобок. My brother has been living in Berlin (...) over five years.";
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


                var B1B2ENG41button = new InlineKeyboardButton();
                B1B2ENG41button.setText("from");
                B1B2ENG41button.setCallbackData("B1B2ENG41_BUTTON"); // Английский язык первая цифра - первое слово, вторая цифра первый вариант перевода
                var B1B2ENG42button = new InlineKeyboardButton();
                B1B2ENG42button.setText("at");
                B1B2ENG42button.setCallbackData("B1B2ENG42_BUTTON");
                var B1B2ENG43button = new InlineKeyboardButton();
                B1B2ENG43button.setText("for"); // правильный ответ
                B1B2ENG43button.setCallbackData("B1B2ENG43_BUTTON");

                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(B1B2ENG41button);
                rowInline2.add(B1B2ENG42button);
                rowInline3.add(B1B2ENG43button);
                rowInline4.add(BACKLANGbutton);
                rowInline5.add(BACKLEVELENGbutton);
                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2);
                rowsInline.add(rowInline3);
                rowsInline.add(rowInline4);
                rowsInline.add(rowInline5);
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("B1B2ENG41_BUTTON") || callbackData.equals("B1B2ENG42_BUTTON") || callbackData.equals("B1B2ENG43_BUTTON"))
            {
                if(callbackData.equals("B1B2ENG43_BUTTON"))
                {
                    d += 1;
                }
                if (c == d && c != 0 && d != 0)
                {
                    String text = "Выберите вариант ответа, который должен стоять на месте скобок. I couldn't go to the party because I (...) my project.";
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
                    var B1B2ENG51button = new InlineKeyboardButton();
                    B1B2ENG51button.setText("have finished");
                    B1B2ENG51button.setCallbackData("B1B2ENG51_BUTTON"); // Английский язык первая цифра - первое слово, вторая цифра первый вариант перевода
                    var B1B2ENG52button = new InlineKeyboardButton();
                    B1B2ENG52button.setText("must finish");
                    B1B2ENG52button.setCallbackData("B1B2ENG52_BUTTON");
                    var B1B2ENG53button = new InlineKeyboardButton();
                    B1B2ENG53button.setText("had to finish");
                    B1B2ENG53button.setCallbackData("B1B2ENG53_BUTTON");
                    var BACKLANGbutton = new InlineKeyboardButton();
                    BACKLANGbutton.setText("Вернуться к выбору языка");
                    BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                    var BACKLEVELENGbutton = new InlineKeyboardButton();
                    BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                    BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");
                    rowInline1.add(B1B2ENG51button);
                    rowInline2.add(B1B2ENG52button);
                    rowInline3.add(B1B2ENG53button);
                    rowInline4.add(BACKLANGbutton);
                    rowInline5.add(BACKLEVELENGbutton);
                    rowsInline.add(rowInline1);
                    rowsInline.add(rowInline2);
                    rowsInline.add(rowInline3);
                    rowsInline.add(rowInline4);
                    rowsInline.add(rowInline5);
                    markupInline.setKeyboard(rowsInline);
                    message.setReplyMarkup(markupInline);
                    exe(message);
                }
                if (c == 0 && d == 0)
                {
                    String text = "Вы ответили неправильно на все вопросы, рекомендую понизить уровень языка";
                    EditMessageText message = new EditMessageText();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(text);
                    message.setMessageId((int) messageId);
                    exe(message);
                }
                else
                {
                    if (c < d)
                    {
                        String text = "Ваш уровень владения английским языком соответствует уровню B2";
                        EditMessageText message = new EditMessageText();
                        message.setChatId(String.valueOf(chatId));
                        message.setText(text);
                        message.setMessageId((int) messageId);
                        exe(message);
                    }
                    if (c > d)
                    {
                        String text = "Ваш уровень владения английским языком соответствует уровню B1";
                        EditMessageText message = new EditMessageText();
                        message.setChatId(String.valueOf(chatId));
                        message.setText(text);
                        message.setMessageId((int) messageId);
                        exe(message);
                    }

                }
            }
            if(callbackData.equals("B1B2ENG51_BUTTON") || callbackData.equals("B1B2ENG52_BUTTON"))
            {
                String text = "Ваш уровень владения английским языком соответствует уровню B1";
                EditMessageText message = new EditMessageText();
                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                exe(message);
            }
            if(callbackData.equals("B1B2ENG53_BUTTON"))
            {

                String text = "Ваш уровень владения английским языком соответствует уровню B2";
                EditMessageText message = new EditMessageText();
                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                exe(message);
            }





















            if(callbackData.equals("C1C2ENG_BUTTON"))
            {
                i = 0;
                f = 0;
                String text = "Выберите вариант ответа, который должен стоять на месте скобок. She is very good (...) playing the piano.";
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
                var C1C2ENG11button = new InlineKeyboardButton();
                C1C2ENG11button.setText("for");
                C1C2ENG11button.setCallbackData("C1C2ENG11_BUTTON"); // Английский язык первая цифра - первое слово, вторая цифра первый вариант перевода
                var C1C2ENG12button = new InlineKeyboardButton();
                C1C2ENG12button.setText("at");// правильный ответ
                C1C2ENG12button.setCallbackData("C1C2ENG12_BUTTON");
                var C1C2ENG13button = new InlineKeyboardButton();
                C1C2ENG13button.setText("in");
                C1C2ENG13button.setCallbackData("C1C2ENG13_BUTTON");

                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(C1C2ENG11button);
                rowInline2.add(C1C2ENG12button);
                rowInline3.add(C1C2ENG13button);
                rowInline4.add(BACKLANGbutton);
                rowInline5.add(BACKLEVELENGbutton);
                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2);
                rowsInline.add(rowInline3);
                rowsInline.add(rowInline4);
                rowsInline.add(rowInline5);
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("C1C2ENG11_BUTTON") || callbackData.equals("C1C2ENG12_BUTTON") || callbackData.equals("C1C2ENG13_BUTTON"))
            {
                if(callbackData.equals("C1C2ENG12_BUTTON"))
                {
                    i += 1;
                }

                String text = "Выберите вариант ответа, который должен стоять на месте скобок. I am not familiar (...) the new system yet.";
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
                var C1C2ENG21button = new InlineKeyboardButton();
                C1C2ENG21button.setText("with"); // правильный ответ
                C1C2ENG21button.setCallbackData("C1C2ENG21_BUTTON"); // Английский язык первая цифра - первое слово, вторая цифра первый вариант перевода
                var C1C2ENG22button = new InlineKeyboardButton();
                C1C2ENG22button.setText("by");
                C1C2ENG22button.setCallbackData("C1C2ENG22_BUTTON");
                var C1C2ENG23button = new InlineKeyboardButton();
                C1C2ENG23button.setText("to");
                C1C2ENG23button.setCallbackData("C1C2ENG23_BUTTON");

                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(C1C2ENG21button);
                rowInline2.add(C1C2ENG22button);
                rowInline3.add(C1C2ENG23button);
                rowInline4.add(BACKLANGbutton);
                rowInline5.add(BACKLEVELENGbutton);
                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2);
                rowsInline.add(rowInline3);
                rowsInline.add(rowInline4);
                rowsInline.add(rowInline5);
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("C1C2ENG21_BUTTON") || callbackData.equals("C1C2ENG22_BUTTON") || callbackData.equals("C1C2ENG23_BUTTON"))
            {

                if(callbackData.equals("C1C2ENG21_BUTTON"))
                {
                    f += 1;
                }
                String text = "Выберите вариант ответа, который должен стоять на месте скобок.  I can't believe you (...) the concert last night!";
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


                var C1C2ENG31button = new InlineKeyboardButton();
                C1C2ENG31button.setText("missed");// правильный ответ
                C1C2ENG31button.setCallbackData("C1C2ENG31_BUTTON"); // Английский язык первая цифра - первое слово, вторая цифра первый вариант перевода
                var C1C2ENG32button = new InlineKeyboardButton();
                C1C2ENG32button.setText("lost");
                C1C2ENG32button.setCallbackData("C1C2ENG32_BUTTON");
                var C1C2ENG33button = new InlineKeyboardButton();
                C1C2ENG33button.setText("skip");
                C1C2ENG33button.setCallbackData("C1C2ENG33_BUTTON");

                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(C1C2ENG31button);
                rowInline2.add(C1C2ENG32button);
                rowInline3.add(C1C2ENG33button);
                rowInline4.add(BACKLANGbutton);
                rowInline5.add(BACKLEVELENGbutton);
                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2);
                rowsInline.add(rowInline3);
                rowsInline.add(rowInline4);
                rowsInline.add(rowInline5);
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("C1C2ENG31_BUTTON") || callbackData.equals("C1C2ENG32_BUTTON") || callbackData.equals("C1C2ENG33_BUTTON"))
            {
                if(callbackData.equals("C1C2ENG31_BUTTON"))
                {
                    i += 1;
                }
                String text = "Выберите вариант ответа, который должен стоять на месте скобок. It was (...) she received the news that she had won the award.";
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


                var C1C2ENG41button = new InlineKeyboardButton();
                C1C2ENG41button.setText("scarcely");
                C1C2ENG41button.setCallbackData("C1C2ENG41_BUTTON"); // Английский язык первая цифра - первое слово, вторая цифра первый вариант перевода
                var C1C2ENG42button = new InlineKeyboardButton();
                C1C2ENG42button.setText("hardly");
                C1C2ENG42button.setCallbackData("C1C2ENG42_BUTTON");
                var C1C2ENG43button = new InlineKeyboardButton();
                C1C2ENG43button.setText("just"); // правильный ответ
                C1C2ENG43button.setCallbackData("C1C2ENG43_BUTTON");

                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(C1C2ENG41button);
                rowInline2.add(C1C2ENG42button);
                rowInline3.add(C1C2ENG43button);
                rowInline4.add(BACKLANGbutton);
                rowInline5.add(BACKLEVELENGbutton);
                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2);
                rowsInline.add(rowInline3);
                rowsInline.add(rowInline4);
                rowsInline.add(rowInline5);
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("C1C2ENG41_BUTTON") || callbackData.equals("C1C2ENG42_BUTTON") || callbackData.equals("C1C2ENG43_BUTTON"))
            {
                if(callbackData.equals("C1C2ENG43_BUTTON"))
                {
                    f += 1;
                }
                if (i == f && i != 0 && f != 0)
                {
                    String text = "Выберите вариант ответа, который должен стоять на месте скобок. (...) he considered his options, he made the decision to resign.";
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
                    var C1C2ENG51button = new InlineKeyboardButton();
                    C1C2ENG51button.setText("Although");
                    C1C2ENG51button.setCallbackData("C1C2ENG51_BUTTON"); // Английский язык первая цифра - первое слово, вторая цифра первый вариант перевода
                    var C1C2ENG52button = new InlineKeyboardButton();
                    C1C2ENG52button.setText("Despite");
                    C1C2ENG52button.setCallbackData("C1C2ENG52_BUTTON");
                    var C1C2ENG53button = new InlineKeyboardButton();
                    C1C2ENG53button.setText("Nevertheless");
                    C1C2ENG53button.setCallbackData("C1C2ENG53_BUTTON");
                    var BACKLANGbutton = new InlineKeyboardButton();
                    BACKLANGbutton.setText("Вернуться к выбору языка");
                    BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                    var BACKLEVELENGbutton = new InlineKeyboardButton();
                    BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                    BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");
                    rowInline1.add(C1C2ENG51button);
                    rowInline2.add(C1C2ENG52button);
                    rowInline3.add(C1C2ENG53button);
                    rowInline4.add(BACKLANGbutton);
                    rowInline5.add(BACKLEVELENGbutton);
                    rowsInline.add(rowInline1);
                    rowsInline.add(rowInline2);
                    rowsInline.add(rowInline3);
                    rowsInline.add(rowInline4);
                    rowsInline.add(rowInline5);
                    markupInline.setKeyboard(rowsInline);
                    message.setReplyMarkup(markupInline);
                    exe(message);
                }
                if (i == 0 && f == 0)
                {
                    String text = "Вы ответили неправильно на все вопросы, рекомендую понизить уровень языка";
                    EditMessageText message = new EditMessageText();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(text);
                    message.setMessageId((int) messageId);
                    exe(message);
                }
                else
                {
                    if (i < f)
                    {
                        String text = "Ваш уровень владения английским языком соответствует уровню C2";
                        EditMessageText message = new EditMessageText();
                        message.setChatId(String.valueOf(chatId));
                        message.setText(text);
                        message.setMessageId((int) messageId);
                        exe(message);
                    }
                    if (i > f)
                    {
                        String text = "Ваш уровень владения английским языком соответствует уровню C1";
                        EditMessageText message = new EditMessageText();
                        message.setChatId(String.valueOf(chatId));
                        message.setText(text);
                        message.setMessageId((int) messageId);
                        exe(message);
                    }
                }

            }
            if(callbackData.equals("C1C2ENG51_BUTTON"))
            {
                String text = "Ваш уровень владения английским языком соответствует уровню C2";
                EditMessageText message = new EditMessageText();
                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                exe(message);
            }
            if(callbackData.equals("C1C2ENG52_BUTTON") || callbackData.equals("C1C2ENG53_BUTTON"))
            {
                String text = "Ваш уровень владения английским языком соответствует уровню C1";
                EditMessageText message = new EditMessageText();
                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                exe(message);
            }



















            if(callbackData.equals("BACKLANG1_BUTTON"))
            {
                SendMessage message = new SendMessage();
                message.setChatId(String.valueOf(chatId));
                message.setText("Выбери интересующий тебя язык");
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline1 = new ArrayList<>();

                List<InlineKeyboardButton> rowInline2 = new ArrayList<>();

                List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                var ENGbutton = new InlineKeyboardButton();
                ENGbutton.setText("Английский");
                ENGbutton.setCallbackData("ENG_BUTTON");
                var GERbutton = new InlineKeyboardButton();
                GERbutton.setText("Немецкий");
                GERbutton.setCallbackData("GER_BUTTON");
                var FREbutton = new InlineKeyboardButton();
                FREbutton.setText("Французский");
                FREbutton.setCallbackData("FRE_BUTTON");

                rowInline1.add(ENGbutton);
                rowInline2.add(GERbutton);
                rowInline3.add(FREbutton);
                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2);
                rowsInline.add(rowInline3);
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                try
                {
                    execute(message);
                }
                catch (TelegramApiException e)
                {
                }
            }
            if(callbackData.equals("BACKLEVELENG_BUTTON"))
            {
                String text = "Выбери тот уровень языка, на который, по твоему мнению, ты знаешь английский язык";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int)messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline1 = new ArrayList<>();

                List<InlineKeyboardButton> rowInline2 = new ArrayList<>();

                List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                var A1A2button = new InlineKeyboardButton();
                A1A2button.setText("Минимальный");
                A1A2button.setCallbackData("A1A2_BUTTON");
                var B1B2button = new InlineKeyboardButton();
                B1B2button.setText("Средний");
                B1B2button.setCallbackData("B1B2_BUTTON");
                var C1C2button = new InlineKeyboardButton();
                C1C2button.setText("Максимальный");
                C1C2button.setCallbackData("C1C2_BUTTON");
                rowInline1.add(A1A2button);
                rowInline2.add(B1B2button);
                rowInline3.add(C1C2button);
                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2);
                rowsInline.add(rowInline3);
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                try
                {
                    execute(message);
                }
                catch (TelegramApiException e)
                {
                }
            }
            if(callbackData.equals("BACKLEVELGER_BUTTON"))
            {
                String text = "Выбери тот уровень языка, на который, по твоему мнению, ты знаешь немецкий язык";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int)messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline1 = new ArrayList<>();

                List<InlineKeyboardButton> rowInline2 = new ArrayList<>();

                List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                var A1A2button = new InlineKeyboardButton();
                A1A2button.setText("Минимальный");
                A1A2button.setCallbackData("A1A2_BUTTON");
                var B1B2button = new InlineKeyboardButton();
                B1B2button.setText("Средний");
                B1B2button.setCallbackData("B1B2_BUTTON");
                var C1C2button = new InlineKeyboardButton();
                C1C2button.setText("Максимальный");
                C1C2button.setCallbackData("C1C2_BUTTON");
                rowInline1.add(A1A2button);
                rowInline2.add(B1B2button);
                rowInline3.add(C1C2button);
                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2);
                rowsInline.add(rowInline3);
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                try
                {
                    execute(message);
                }
                catch (TelegramApiException e)
                {
                }
            }
            if(callbackData.equals("BACKLEVELFRE_BUTTON"))
            {
                String text = "Выбери тот уровень языка, на который, по твоему мнению, ты знаешь французский язык";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int)messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline1 = new ArrayList<>();

                List<InlineKeyboardButton> rowInline2 = new ArrayList<>();

                List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                var A1A2button = new InlineKeyboardButton();
                A1A2button.setText("Минимальный");
                A1A2button.setCallbackData("A1A2_BUTTON");
                var B1B2button = new InlineKeyboardButton();
                B1B2button.setText("Средний");
                B1B2button.setCallbackData("B1B2_BUTTON");
                var C1C2button = new InlineKeyboardButton();
                C1C2button.setText("Максимальный");
                C1C2button.setCallbackData("C1C2_BUTTON");
                rowInline1.add(A1A2button);
                rowInline2.add(B1B2button);
                rowInline3.add(C1C2button);
                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2);
                rowsInline.add(rowInline3);
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
        }
    }
    private void exe(EditMessageText message)
    {
        try
        {
            execute(message);
        }
        catch (TelegramApiException e)
        {
        }
    }
    private void startCommandReceived(long chatId, String name)
    {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Привет, " + name + ", этот тест поможет тебе определить твой уровень владения этими языками. Выбери интересующий тебя язык.");
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
        var ENGbutton = new InlineKeyboardButton();
        ENGbutton.setText("Английский");
        ENGbutton.setCallbackData("ENG_BUTTON");
        var GERbutton = new InlineKeyboardButton();
        GERbutton.setText("Немецкий");
        GERbutton.setCallbackData("GER_BUTTON");
        var FREbutton = new InlineKeyboardButton();
        FREbutton.setText("Французский");
        FREbutton.setCallbackData("FRE_BUTTON");

        rowInline1.add(ENGbutton);
        rowInline2.add(GERbutton);
        rowInline3.add(FREbutton);

        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2);
        rowsInline.add(rowInline3);
        var BACKLANGbutton = new InlineKeyboardButton();
        BACKLANGbutton.setText("Вернуться к выбору языка");
        BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
        var BACKLEVELENGbutton = new InlineKeyboardButton();
        BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
        BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");
        var BACKLEVELGERbutton = new InlineKeyboardButton();
        BACKLEVELGERbutton.setText("Вернуться к выбору уровня языка");
        BACKLEVELGERbutton.setCallbackData("BACKLEVELGER_BUTTON");
        var BACKLEVELFREbutton = new InlineKeyboardButton();
        BACKLEVELFREbutton.setText("Вернуться к выбору уровня языка");
        BACKLEVELFREbutton.setCallbackData("BACKLEVELFRE_BUTTON");
        rowsInline.add(rowInline);
        markupInline.setKeyboard(rowsInline);
        message.setReplyMarkup(markupInline);
        try
        {
            execute(message);
        }
        catch (TelegramApiException e)
        {

        }
    }
    private void sendMessage(long chatId, String textToSend)
    {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        try
        {
            execute(message);
        }
        catch (TelegramApiException e)
        {

        }
    }
}