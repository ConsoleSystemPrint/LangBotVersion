package com.example.langbot.service;
import com.example.langbot.config.BotConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
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
                message.setMessageId((int) messageId);

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
                List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline3 = new ArrayList<>();

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
                List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline3 = new ArrayList<>();

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
               // A1A21 eng = new A1A21();
               // eng.A1A2ENG1();
               A1A2ENG1(chatId, messageId);
                //exe(message);
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
                List<InlineKeyboardButton> rowInline1 = new ArrayList<>(); List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline3 = new ArrayList<>(); List<InlineKeyboardButton> rowInline4 = new ArrayList<>();

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

                rowInline1.add(A1A2ENG21button); rowInline2.add(A1A2ENG22button);
                rowInline3.add(A1A2ENG23button); rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1); rowsInline.add(rowInline2);
                rowsInline.add(rowInline3); rowsInline.add(rowInline4); rowsInline.add(rowInline5);

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
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

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

                rowInline1.add(A1A2ENG31button); rowInline2.add(A1A2ENG32button);
                rowInline3.add(A1A2ENG33button); rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1); rowsInline.add(rowInline2);
                rowsInline.add(rowInline3); rowsInline.add(rowInline4); rowsInline.add(rowInline5);
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
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

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

                rowInline1.add(A1A2ENG41button); rowInline2.add(A1A2ENG42button);
                rowInline3.add(A1A2ENG43button); rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1); rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                rowsInline.add(rowInline4); rowsInline.add(rowInline5);
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
                    List<InlineKeyboardButton> rowInline1 = new ArrayList<>(); List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline3 = new ArrayList<>(); List<InlineKeyboardButton> rowInline4 = new ArrayList<>();
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

                    rowInline1.add(A1A2ENG51button); rowInline2.add(A1A2ENG52button);
                    rowInline3.add(A1A2ENG53button); rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                    rowsInline.add(rowInline1); rowsInline.add(rowInline2);
                    rowsInline.add(rowInline3); rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                    markupInline.setKeyboard(rowsInline);
                    message.setReplyMarkup(markupInline);
                    exe(message);
                }
                if (a == 0 && b == 0)
                {
                    messageText("Вы ответили неправильно на все вопросы, рекомендую понизить уровень языка", chatId, messageId);
                }
                else
                {
                    if (a < b)
                    {
                        messageText("Ваш уровень владения английским языком соответствует уровню А2", chatId, messageId);
                    }
                    if (a > b)
                    {
                        messageText("Ваш уровень владения английским языком соответствует уровню А1", chatId, messageId);
                    }
                }
            }
            if(callbackData.equals("A1A2ENG51_BUTTON") || callbackData.equals("A1A2ENG53_BUTTON"))
            {
                messageText("Ваш уровень владения английским языком соответствует уровню А1", chatId, messageId);
            }
            if(callbackData.equals("A1A2ENG52_BUTTON"))
            {
                messageText("Ваш уровень владения английским языком соответствует уровню А2", chatId, messageId);
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
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();
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

                rowInline1.add(B1B2ENG11button); rowInline2.add(B1B2ENG12button);
                rowInline3.add(B1B2ENG13button); rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1); rowsInline.add(rowInline2);
                rowsInline.add(rowInline3); rowsInline.add(rowInline4); rowsInline.add(rowInline5);
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
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

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

                rowInline1.add(B1B2ENG21button); rowInline2.add(B1B2ENG22button);
                rowInline3.add(B1B2ENG23button); rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1); rowsInline.add(rowInline2);
                rowsInline.add(rowInline3); rowsInline.add(rowInline4); rowsInline.add(rowInline5);

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
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

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

                rowInline1.add(B1B2ENG31button); rowInline2.add(B1B2ENG32button);
                rowInline3.add(B1B2ENG33button); rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1); rowsInline.add(rowInline2);
                rowsInline.add(rowInline3); rowsInline.add(rowInline4); rowsInline.add(rowInline5);

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
                List<InlineKeyboardButton> rowInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

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

                rowInline1.add(B1B2ENG41button); rowInline2.add(B1B2ENG42button);
                rowInline3.add(B1B2ENG43button); rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1); rowsInline.add(rowInline2);
                rowsInline.add(rowInline3); rowsInline.add(rowInline4); rowsInline.add(rowInline5);

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
                    List<InlineKeyboardButton> rowInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

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

                    rowInline1.add(B1B2ENG51button); rowInline2.add(B1B2ENG52button);
                    rowInline3.add(B1B2ENG53button); rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                    rowsInline.add(rowInline1); rowsInline.add(rowInline2);
                    rowsInline.add(rowInline3); rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                    markupInline.setKeyboard(rowsInline);
                    message.setReplyMarkup(markupInline);
                    exe(message);
                }
                if (c == 0 && d == 0)
                {
                    messageText("Вы ответили неправильно на все вопросы, рекомендую понизить уровень языка", chatId, messageId);
                }
                else
                {
                    if (c < d)
                    {
                        messageText("Ваш уровень владения английским языком соответствует уровню B2", chatId, messageId);
                    }
                    if (c > d)
                    {
                        messageText("Ваш уровень владения английским языком соответствует уровню B1", chatId, messageId);
                    }

                }
            }
            if(callbackData.equals("B1B2ENG51_BUTTON") || callbackData.equals("B1B2ENG52_BUTTON"))
            {
                messageText("Ваш уровень владения английским языком соответствует уровню B1", chatId, messageId);
            }
            if(callbackData.equals("B1B2ENG53_BUTTON"))
            {
                messageText("Ваш уровень владения английским языком соответствует уровню B2", chatId, messageId);
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
                List<InlineKeyboardButton> rowInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                var C1C2ENG11button = new InlineKeyboardButton();
                C1C2ENG11button.setText("for");
                C1C2ENG11button.setCallbackData("C1C2ENG11_BUTTON");
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

                rowInline1.add(C1C2ENG11button); rowInline2.add(C1C2ENG12button);
                rowInline3.add(C1C2ENG13button); rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1); rowsInline.add(rowInline2);
                rowsInline.add(rowInline3); rowsInline.add(rowInline4); rowsInline.add(rowInline5);

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
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                var C1C2ENG21button = new InlineKeyboardButton();
                C1C2ENG21button.setText("with"); // правильный ответ
                C1C2ENG21button.setCallbackData("C1C2ENG21_BUTTON");
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

                rowInline1.add(C1C2ENG21button); rowInline2.add(C1C2ENG22button);
                rowInline3.add(C1C2ENG23button); rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                rowsInline.add(rowInline4); rowsInline.add(rowInline5);

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
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();


                var C1C2ENG31button = new InlineKeyboardButton();
                C1C2ENG31button.setText("missed");// правильный ответ
                C1C2ENG31button.setCallbackData("C1C2ENG31_BUTTON");
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

                rowInline1.add(C1C2ENG31button); rowInline2.add(C1C2ENG32button);
                rowInline3.add(C1C2ENG33button); rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                rowsInline.add(rowInline4); rowsInline.add(rowInline5);

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
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                var C1C2ENG41button = new InlineKeyboardButton();
                C1C2ENG41button.setText("scarcely");
                C1C2ENG41button.setCallbackData("C1C2ENG41_BUTTON");
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
                rowInline2.add(C1C2ENG42button); rowInline3.add(C1C2ENG43button);
                rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1); rowsInline.add(rowInline2);
                rowsInline.add(rowInline3); rowsInline.add(rowInline4); rowsInline.add(rowInline5);

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
                    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                    var C1C2ENG51button = new InlineKeyboardButton();
                    C1C2ENG51button.setText("Although");
                    C1C2ENG51button.setCallbackData("C1C2ENG51_BUTTON");
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

                    rowInline1.add(C1C2ENG51button); rowInline2.add(C1C2ENG52button);
                    rowInline3.add(C1C2ENG53button); rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                    rowsInline.add(rowInline1); rowsInline.add(rowInline2);
                    rowsInline.add(rowInline3); rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                    markupInline.setKeyboard(rowsInline);
                    message.setReplyMarkup(markupInline);
                    exe(message);
                }
                if (i == 0 && f == 0)
                {
                    messageText("Вы ответили неправильно на все вопросы, рекомендую понизить уровень языка", chatId, messageId);
                }
                else
                {
                    if (i < f)
                    {
                        messageText("Ваш уровень владения английским языком соответствует уровню C2", chatId, messageId);
                    }
                    if (i > f)
                    {
                        messageText("Ваш уровень владения английским языком соответствует уровню C1", chatId, messageId);
                    }
                }

            }
            if(callbackData.equals("C1C2ENG51_BUTTON"))
            {
                messageText("Ваш уровень владения английским языком соответствует уровню C2", chatId, messageId);
            }
            if(callbackData.equals("C1C2ENG52_BUTTON") || callbackData.equals("C1C2ENG53_BUTTON"))
            {
                messageText("Ваш уровень владения английским языком соответствует уровню C1", chatId, messageId);
            }


            if(callbackData.equals("A1A2GER_BUTTON"))
            {
                a1 = 0; b1 = 0;
                String text = "Выберите вариант ответа, который должен стоять на месте скобок. \n Vervollständige den Satz: Ich (…) gut.";
                EditMessageText message = new EditMessageText();
                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int)messageId);

                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                var A1A2GER11button = new InlineKeyboardButton();
                A1A2GER11button.setText("ist");
                A1A2GER11button.setCallbackData("A1A2GER11_BUTTON");
                var A1A2GER12button = new InlineKeyboardButton();
                A1A2GER12button.setText("bin");
                A1A2GER12button.setCallbackData("A1A2GER12_BUTTON");
                var A1A2GER13button = new InlineKeyboardButton();
                A1A2GER13button.setText("bist");
                A1A2GER13button.setCallbackData("A1A2GER13_BUTTON");
                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(A1A2GER11button); rowInline2.add(A1A2GER12button);
                rowInline3.add(A1A2GER13button); rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1); rowsInline.add(rowInline2);
                rowsInline.add(rowInline3); rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }

            if(callbackData.equals("A1A2GER11_BUTTON") || callbackData.equals("A1A2GER12_BUTTON") || callbackData.equals("A1A2GER13_BUTTON")) {
                if (callbackData.equals("A1A2GER12_BUTTON"))
                {
                    a1 += 1 ;
                }
                {
                    String text = "Выберите вариант ответа, который должен стоять на месте скобок. \n Setze das richtige Wort ein: Wir gehen (...)";
                    EditMessageText message = new EditMessageText();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(text);
                    message.setMessageId((int) messageId);
                    InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                    var A1A2GER11button = new InlineKeyboardButton();
                    A1A2GER11button.setText("schwimmen");
                    A1A2GER11button.setCallbackData("A1A2GER21_BUTTON");
                    var A1A2GER12button = new InlineKeyboardButton();
                    A1A2GER12button.setText("schwimmst");
                    A1A2GER12button.setCallbackData("A1A2GER22_BUTTON");
                    var A1A2GER13button = new InlineKeyboardButton();
                    A1A2GER13button.setText("schwimmt");
                    A1A2GER13button.setCallbackData("A1A2GER23_BUTTON");
                    var BACKLANGbutton = new InlineKeyboardButton();
                    BACKLANGbutton.setText("Вернуться к выбору языка");
                    BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                    var BACKLEVELENGbutton = new InlineKeyboardButton();
                    BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                    BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                    rowInline1.add(A1A2GER11button); rowInline2.add(A1A2GER12button);
                    rowInline3.add(A1A2GER13button); rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                    rowsInline.add(rowInline1);
                    rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                    rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                    markupInline.setKeyboard(rowsInline);
                    message.setReplyMarkup(markupInline);
                    exe(message);
                }
            }
            if(callbackData.equals("A1A2GER21_BUTTON") || callbackData.equals("A1A2GER22_BUTTON") || callbackData.equals("A1A2GER23_BUTTON"))
            {

                if(callbackData.equals("A1A2GER21_BUTTON"))
                {
                    b1 += 1;
                }
                String text = "Выберите вариант ответа, который должен стоять на месте скобок. \n Welches Wort passt? Sie (...) Lehrerin.";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();


                var A1A2ENG31button = new InlineKeyboardButton();
                A1A2ENG31button.setText("bin");
                A1A2ENG31button.setCallbackData("A1A2GER31_BUTTON");
                var A1A2ENG32button = new InlineKeyboardButton();
                A1A2ENG32button.setText("sind");
                A1A2ENG32button.setCallbackData("A1A2GER32_BUTTON");
                var A1A2ENG33button = new InlineKeyboardButton();
                A1A2ENG33button.setText("ist");// правильный ответ
                A1A2ENG33button.setCallbackData("A1A2GER33_BUTTON");
                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(A1A2ENG31button);
                rowInline2.add(A1A2ENG32button); rowInline3.add(A1A2ENG33button);
                rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("A1A2GER31_BUTTON") || callbackData.equals("A1A2GER32_BUTTON") || callbackData.equals("A1A2GER33_BUTTON"))
            {
                if(callbackData.equals("A1A2GER33_BUTTON"))
                {
                    a1 += 1;
                }
                String text = "Выберите вариант ответа, который должен стоять на месте скобок. \n Wann bist du (...) Berlin gekommen?";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                var C1C2ENG41button = new InlineKeyboardButton();
                C1C2ENG41button.setText("in");
                C1C2ENG41button.setCallbackData("A1A2GER41_BUTTON");
                var C1C2ENG42button = new InlineKeyboardButton();
                C1C2ENG42button.setText("nach");// правильный ответ
                C1C2ENG42button.setCallbackData("A1A2GER42_BUTTON");
                var C1C2ENG43button = new InlineKeyboardButton();
                C1C2ENG43button.setText("auf");
                C1C2ENG43button.setCallbackData("A1A2GER43_BUTTON");
                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(C1C2ENG41button); rowInline2.add(C1C2ENG42button);
                rowInline3.add(C1C2ENG43button); rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1); rowsInline.add(rowInline2);
                rowsInline.add(rowInline3); rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("A1A2GER41_BUTTON") || callbackData.equals("A1A2GER42_BUTTON") || callbackData.equals("A1A2GER43_BUTTON"))
            {
                if(callbackData.equals("A1A2GER42_BUTTON"))
                {
                    b1 += 1;
                }
                if (a1 == b1 && a1 != 0 && b1 != 0)
                {
                    String text = "Образуйте причастие от слова machen.";
                    EditMessageText message = new EditMessageText();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(text);
                    message.setMessageId((int) messageId);
                    InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                    var C1C2ENG51button = new InlineKeyboardButton();
                    C1C2ENG51button.setText("gemacht");
                    C1C2ENG51button.setCallbackData("A1A2GER51_BUTTON");
                    var C1C2ENG52button = new InlineKeyboardButton();
                    C1C2ENG52button.setText("machtest");
                    C1C2ENG52button.setCallbackData("A1A2GER52_BUTTON");
                    var C1C2ENG53button = new InlineKeyboardButton();
                    C1C2ENG53button.setText("macht");
                    C1C2ENG53button.setCallbackData("A1A2GER53_BUTTON");
                    var BACKLANGbutton = new InlineKeyboardButton();
                    BACKLANGbutton.setText("Вернуться к выбору языка");
                    BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                    var BACKLEVELENGbutton = new InlineKeyboardButton();
                    BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                    BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");
                    rowInline1.add(C1C2ENG51button);
                    rowInline2.add(C1C2ENG52button); rowInline3.add(C1C2ENG53button);
                    rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                    rowsInline.add(rowInline1); rowsInline.add(rowInline2);
                    rowsInline.add(rowInline3); rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                    markupInline.setKeyboard(rowsInline);
                    message.setReplyMarkup(markupInline);
                    exe(message);
                }
                if (a1 == 0 && b1 == 0)
                {
                    messageText("Вы ответили неправильно на все вопросы, рекомендую понизить уровень языка", chatId, messageId);
                }
                else
                {
                    if (a1 < b1)
                    {
                        messageText("Ваш уровень владения немецким языком соответствует уровню A2", chatId, messageId);
                    }
                    if (a1 > b1)
                    {
                        messageText("Ваш уровень владения немецким языком соответствует уровню A1", chatId, messageId);
                    }
                }
            }
            if(callbackData.equals("A1A2GER51_BUTTON"))
            {
                messageText("Ваш уровень владения немецким языком соответствует уровню A2", chatId, messageId);
            }
            if(callbackData.equals("A1A2GER52_BUTTON") || callbackData.equals("A1A2GER53_BUTTON"))
            {
                messageText("Ваш уровень владения немецким языком соответствует уровню A1", chatId, messageId);
            }


            if(callbackData.equals("B1B2GER_BUTTON"))
            {
                c1 = 0; d1 = 0;
                String text = "Как правильно использовать слово в этом предложении? \n Ich bin (...) in die Stadt gegangen.";
                EditMessageText message = new EditMessageText();
                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int)messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                var A1A2GER11button = new InlineKeyboardButton();
                A1A2GER11button.setText("gern");
                A1A2GER11button.setCallbackData("B1B2GER11_BUTTON");
                var A1A2GER12button = new InlineKeyboardButton();
                A1A2GER12button.setText("oft");
                A1A2GER12button.setCallbackData("B1B2GER12_BUTTON");
                var A1A2GER13button = new InlineKeyboardButton();
                A1A2GER13button.setText("allein");
                A1A2GER13button.setCallbackData("B1B2GER13_BUTTON");
                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(A1A2GER11button); rowInline2.add(A1A2GER12button);
                rowInline3.add(A1A2GER13button); rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1); rowsInline.add(rowInline2);
                rowsInline.add(rowInline3); rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }

            if(callbackData.equals("B1B2GER11_BUTTON") || callbackData.equals("B1B2GER12_BUTTON") || callbackData.equals("B1B2GER13_BUTTON"))
            {
                if (callbackData.equals("B1B2GER13_BUTTON"))
                {
                    c1 += 1 ;
                }
                {
                    String text = "Какое выражение используется для выражения своего мнения на счет чего-либо?";
                    EditMessageText message = new EditMessageText();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(text);
                    message.setMessageId((int) messageId);
                    InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                    var A1A2GER11button = new InlineKeyboardButton();
                    A1A2GER11button.setText("Ich denke, dass");
                    A1A2GER11button.setCallbackData("B1B2GER21_BUTTON");
                    var A1A2GER12button = new InlineKeyboardButton();
                    A1A2GER12button.setText("Es scheint mir, dass");
                    A1A2GER12button.setCallbackData("B1B2GER22_BUTTON");
                    var A1A2GER13button = new InlineKeyboardButton();
                    A1A2GER13button.setText("Mir gefällt, dass");
                    A1A2GER13button.setCallbackData("B1B2GER23_BUTTON");
                    var BACKLANGbutton = new InlineKeyboardButton();
                    BACKLANGbutton.setText("Вернуться к выбору языка");
                    BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                    var BACKLEVELENGbutton = new InlineKeyboardButton();
                    BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                    BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                    rowInline1.add(A1A2GER11button); rowInline2.add(A1A2GER12button);
                    rowInline3.add(A1A2GER13button); rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                    rowsInline.add(rowInline1);
                    rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                    rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                    markupInline.setKeyboard(rowsInline);
                    message.setReplyMarkup(markupInline);
                    exe(message);
                }
            }
            if(callbackData.equals("B1B2GER21_BUTTON") || callbackData.equals("B1B2GER22_BUTTON") || callbackData.equals("B1B2GER23_BUTTON"))
            {
                if(callbackData.equals("B1B2GER21_BUTTON"))
                {
                    d1 += 1;
                }
                String text = "Какое слово подходит в этом контексте \n Am Wochenende (...) ich gerne ins Kino.";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                var A1A2ENG31button = new InlineKeyboardButton();
                A1A2ENG31button.setText("gehe");// правильный ответ
                A1A2ENG31button.setCallbackData("B1B2GER31_BUTTON");
                var A1A2ENG32button = new InlineKeyboardButton();
                A1A2ENG32button.setText("geht");
                A1A2ENG32button.setCallbackData("B1B2GER32_BUTTON");
                var A1A2ENG33button = new InlineKeyboardButton();
                A1A2ENG33button.setText("gehen");
                A1A2ENG33button.setCallbackData("B1B2GER33_BUTTON");
                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(A1A2ENG31button); rowInline2.add(A1A2ENG32button);
                rowInline3.add(A1A2ENG33button); rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1); rowsInline.add(rowInline2);
                rowsInline.add(rowInline3); rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("B1B2GER31_BUTTON") || callbackData.equals("B1B2GER32_BUTTON") || callbackData.equals("B1B2GER33_BUTTON"))
            {
                if(callbackData.equals("B1B2GER31_BUTTON"))
                {
                    c1 += 1;
                }
                String text = "Какой предлог используется с глаголом warten в значении ждать кого-то?";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                var C1C2ENG41button = new InlineKeyboardButton();
                C1C2ENG41button.setText("an");
                C1C2ENG41button.setCallbackData("B1B2GER41_BUTTON");
                var C1C2ENG42button = new InlineKeyboardButton();
                C1C2ENG42button.setText("auf");// правильный ответ
                C1C2ENG42button.setCallbackData("B1B2GER42_BUTTON");
                var C1C2ENG43button = new InlineKeyboardButton();
                C1C2ENG43button.setText("vor");
                C1C2ENG43button.setCallbackData("B1B2GER43_BUTTON");
                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(C1C2ENG41button); rowInline2.add(C1C2ENG42button);
                rowInline3.add(C1C2ENG43button); rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("B1B2GER41_BUTTON") || callbackData.equals("B1B2GER42_BUTTON") || callbackData.equals("B1B2GER43_BUTTON"))
            {
                if(callbackData.equals("B1B2GER42_BUTTON"))
                {
                    d1 += 1;
                }
                if (c1 == d1 && c1 != 0 && d1 != 0)
                {
                    String text = "Какая форма причастия употребляется в составе сложного прошедшего времени с глаголом haben?";
                    EditMessageText message = new EditMessageText();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(text);
                    message.setMessageId((int) messageId);
                    InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                    var C1C2ENG51button = new InlineKeyboardButton();
                    C1C2ENG51button.setText("Partizip I");
                    C1C2ENG51button.setCallbackData("B1B2GER51_BUTTON");
                    var C1C2ENG52button = new InlineKeyboardButton();
                    C1C2ENG52button.setText("Partizip II");
                    C1C2ENG52button.setCallbackData("B1B2GER52_BUTTON");
                    var C1C2ENG53button = new InlineKeyboardButton();
                    C1C2ENG53button.setText("Partizip III");
                    C1C2ENG53button.setCallbackData("B1B2GER53_BUTTON");
                    var BACKLANGbutton = new InlineKeyboardButton();
                    BACKLANGbutton.setText("Вернуться к выбору языка");
                    BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                    var BACKLEVELENGbutton = new InlineKeyboardButton();
                    BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                    BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                    rowInline1.add(C1C2ENG51button); rowInline2.add(C1C2ENG52button);
                    rowInline3.add(C1C2ENG53button); rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                    rowsInline.add(rowInline1);
                    rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                    rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                    markupInline.setKeyboard(rowsInline);
                    message.setReplyMarkup(markupInline);
                    exe(message);
                }
                if (c1 == 0 && d1 == 0)
                {
                    messageText("Вы ответили неправильно на все вопросы, рекомендую понизить уровень языка", chatId, messageId);
                }
                else
                {
                    if (c1 < d1)
                    {
                        messageText("Ваш уровень владения немецким языком соответствует уровню B2", chatId, messageId);
                    }
                    if (c1 > d1)
                    {
                        messageText("Ваш уровень владения немецким языком соответствует уровню B1", chatId, messageId);
                    }
                }
            }
            if(callbackData.equals("B1B2GER52_BUTTON"))
            {
                messageText("Ваш уровень владения немецким языком соответствует уровню B2", chatId, messageId);
            }
            if(callbackData.equals("B1B2GER51_BUTTON") || callbackData.equals("B1B2GER53_BUTTON"))
            {
                messageText("Ваш уровень владения немецким языком соответствует уровню B1", chatId, messageId);
            }


            if(callbackData.equals("C1C2GER_BUTTON"))
            {
                i1 = 0; f1 = 0;
                String text = "Какая форма глагола используется в сослагательном наклонении во времени Praeteritum Perfekt?";
                EditMessageText message = new EditMessageText();
                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int)messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                var A1A2GER11button = new InlineKeyboardButton();
                A1A2GER11button.setText("Konjunktiv I");
                A1A2GER11button.setCallbackData("C1C2GER11_BUTTON");
                var A1A2GER12button = new InlineKeyboardButton();
                A1A2GER12button.setText("Konjunktiv II");
                A1A2GER12button.setCallbackData("C1C2GER12_BUTTON");
                var A1A2GER13button = new InlineKeyboardButton();
                A1A2GER13button.setText("Konjunktiv III");
                A1A2GER13button.setCallbackData("C1C2GER13_BUTTON");
                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(A1A2GER11button);
                rowInline2.add(A1A2GER12button); rowInline3.add(A1A2GER13button);
                rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }

            if(callbackData.equals("C1C2GER11_BUTTON") || callbackData.equals("C1C2GER12_BUTTON") || callbackData.equals("C1C2GER13_BUTTON"))
            {
                if (callbackData.equals("C1C2GER12_BUTTON"))
                {
                    i1 += 1 ;
                }
                {
                    String text = "Какой из следующих случаев употребления Konjunktiv I является правильным?";
                    EditMessageText message = new EditMessageText();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(text);
                    message.setMessageId((int) messageId);
                    InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                    var A1A2GER11button = new InlineKeyboardButton();
                    A1A2GER11button.setText("Zum Ausdruck von Möglichkeiten und Annahmen");
                    A1A2GER11button.setCallbackData("C1C2GER21_BUTTON");
                    var A1A2GER12button = new InlineKeyboardButton();
                    A1A2GER12button.setText("Für indirekte Rede");
                    A1A2GER12button.setCallbackData("C1C2GER22_BUTTON");
                    var A1A2GER13button = new InlineKeyboardButton();
                    A1A2GER13button.setText("Im Alltag für die Höflichkeitsformen");
                    A1A2GER13button.setCallbackData("C1C2GER23_BUTTON");
                    var BACKLANGbutton = new InlineKeyboardButton();
                    BACKLANGbutton.setText("Вернуться к выбору языка");
                    BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                    var BACKLEVELENGbutton = new InlineKeyboardButton();
                    BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                    BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                    rowInline1.add(A1A2GER11button);
                    rowInline2.add(A1A2GER12button); rowInline3.add(A1A2GER13button);
                    rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                    rowsInline.add(rowInline1);
                    rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                    rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                    markupInline.setKeyboard(rowsInline);
                    message.setReplyMarkup(markupInline);
                    exe(message);
                }
            }
            if(callbackData.equals("C1C2GER21_BUTTON") || callbackData.equals("C1C2GER22_BUTTON") || callbackData.equals("C1C2GER23_BUTTON"))
            {

                if(callbackData.equals("C1C2GER22_BUTTON"))
                {
                    f1 += 1;
                }
                String text = "Какое слово использовать в этом предложении? \n As war (...) Niederlage, aber sie hat tapfer gekämpft.";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                var A1A2ENG31button = new InlineKeyboardButton();
                A1A2ENG31button.setText("keine");// правильный ответ
                A1A2ENG31button.setCallbackData("C1C2GER31_BUTTON");
                var A1A2ENG32button = new InlineKeyboardButton();
                A1A2ENG32button.setText("irgendeine");
                A1A2ENG32button.setCallbackData("C1C2GER32_BUTTON");
                var A1A2ENG33button = new InlineKeyboardButton();
                A1A2ENG33button.setText("eine");
                A1A2ENG33button.setCallbackData("C1C2GER33_BUTTON");
                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(A1A2ENG31button);
                rowInline2.add(A1A2ENG32button); rowInline3.add(A1A2ENG33button);
                rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("C1C2GER31_BUTTON") || callbackData.equals("C1C2GER32_BUTTON") || callbackData.equals("C1C2GER33_BUTTON"))
            {
                if(callbackData.equals("C1C2GER33_BUTTON"))
                {
                    i1 += 1;
                }
                String text = "Какой падеж используется после предлога wegen?";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                var C1C2ENG41button = new InlineKeyboardButton();
                C1C2ENG41button.setText("Dativ");
                C1C2ENG41button.setCallbackData("C1C2GER41_BUTTON");
                var C1C2ENG42button = new InlineKeyboardButton();
                C1C2ENG42button.setText("Akkusativ");// правильный ответ
                C1C2ENG42button.setCallbackData("C1C2GER42_BUTTON");
                var C1C2ENG43button = new InlineKeyboardButton();
                C1C2ENG43button.setText("Genitiv");
                C1C2ENG43button.setCallbackData("C1C2GER43_BUTTON");
                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(C1C2ENG41button);
                rowInline2.add(C1C2ENG42button); rowInline3.add(C1C2ENG43button);
                rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("C1C2GER41_BUTTON") || callbackData.equals("C1C2GER42_BUTTON") || callbackData.equals("C1C2GER43_BUTTON"))
            {
                if(callbackData.equals("C1C2GER43_BUTTON"))
                {
                    f1 += 1;
                }
                if (i1 == f1 && i1 != 0 && f1 != 0)
                {
                    String text = "Какая форма времени Kant haben Plusquamperfekt состоит из глагола haben и причастия II основного глагола?";
                    EditMessageText message = new EditMessageText();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(text);
                    message.setMessageId((int) messageId);
                    InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                    var C1C2ENG51button = new InlineKeyboardButton();
                    C1C2ENG51button.setText("Konditional II");
                    C1C2ENG51button.setCallbackData("C1C2GER51_BUTTON");
                    var C1C2ENG52button = new InlineKeyboardButton();
                    C1C2ENG52button.setText("Futur II");
                    C1C2ENG52button.setCallbackData("C1C2GER52_BUTTON");
                    var C1C2ENG53button = new InlineKeyboardButton();
                    C1C2ENG53button.setText("Konjunktiv II");
                    C1C2ENG53button.setCallbackData("C1C2GER53_BUTTON");
                    var BACKLANGbutton = new InlineKeyboardButton();
                    BACKLANGbutton.setText("Вернуться к выбору языка");
                    BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                    var BACKLEVELENGbutton = new InlineKeyboardButton();
                    BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                    BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                    rowInline1.add(C1C2ENG51button);
                    rowInline2.add(C1C2ENG52button); rowInline3.add(C1C2ENG53button);
                    rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                    rowsInline.add(rowInline1);
                    rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                    rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                    markupInline.setKeyboard(rowsInline);
                    message.setReplyMarkup(markupInline);
                    exe(message);
                }
                if (i1 == 0 && f1 == 0)
                {
                    messageText("Вы ответили неправильно на все вопросы, рекомендую понизить уровень языка", chatId, messageId);
                }
                else
                {
                    if (i1 < f1)
                    {
                        messageText("Ваш уровень владения немецким языком соответствует уровню C2", chatId, messageId);
                    }
                    if (i1 > f1)
                    {
                        messageText("Ваш уровень владения немецким языком соответствует уровню C1", chatId, messageId);
                    }
                }

            }
            if(callbackData.equals("C1C2GER52_BUTTON"))
            {
                messageText("Ваш уровень владения немецким языком соответствует уровню C2", chatId, messageId);
            }
            if(callbackData.equals("C1C2GER51_BUTTON") || callbackData.equals("C1C2GER53_BUTTON"))
            {
                messageText("Ваш уровень владения немецким языком соответствует уровню C1", chatId, messageId);
            }


            if(callbackData.equals("A1A2FRE_BUTTON"))
            {
                a2 = 0;
                b2 = 0;
                String text = "Выберите правильный цвет. \n Quelle est la couleur du ciel?";
                EditMessageText message = new EditMessageText();
                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                var A1A2FRE11button = new InlineKeyboardButton();
                A1A2FRE11button.setText("bleu");// правильный ответ
                A1A2FRE11button.setCallbackData("A1A2FRE11_BUTTON");
                var A1A2FRE12button = new InlineKeyboardButton();
                A1A2FRE12button.setText("rouge");
                A1A2FRE12button.setCallbackData("A1A2FRE12_BUTTON");
                var A1A2FRE13button = new InlineKeyboardButton();
                A1A2FRE13button.setText("jaune");
                A1A2FRE13button.setCallbackData("A1A2FRE13_BUTTON");
                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(A1A2FRE11button);
                rowInline2.add(A1A2FRE12button); rowInline3.add(A1A2FRE13button);
                rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("A1A2FRE11_BUTTON") || callbackData.equals("A1A2FRE12_BUTTON") || callbackData.equals("A1A2FRE13_BUTTON"))
            {
                if(callbackData.equals("A1A2FRE11_BUTTON"))
                {
                    a2 += 1;
                }
                String text = "Выберите правильную форму будущего времени глагола aller. \n Qu'est-ce que tu vas faire ce weekend?";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                var A1A2FRE21button = new InlineKeyboardButton();
                A1A2FRE21button.setText("Je aller au cinéma");
                A1A2FRE21button.setCallbackData("A1A2FRE21_BUTTON");
                var A1A2FRE22button = new InlineKeyboardButton();
                A1A2FRE22button.setText("Je vais au cinéma");// правильный ответ
                A1A2FRE22button.setCallbackData("A1A2FRE22_BUTTON");
                var A1A2FRE23button = new InlineKeyboardButton();
                A1A2FRE23button.setText("Je vais à la cinéma");
                A1A2FRE23button.setCallbackData("A1A2FRE23_BUTTON");
                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(A1A2FRE21button);
                rowInline2.add(A1A2FRE22button); rowInline3.add(A1A2FRE23button);
                rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("A1A2FRE21_BUTTON") || callbackData.equals("A1A2FRE22_BUTTON") || callbackData.equals("A1A2FRE23_BUTTON"))
            {
                if(callbackData.equals("A1A2FRE22_BUTTON"))
                {
                    b2 += 1;
                }
                String text = "Выберите правильное местоположение. \n Où est la bibliothèque?";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                var A1A2FRE31button = new InlineKeyboardButton();
                A1A2FRE31button.setText("à gauche");// правильный ответ
                A1A2FRE31button.setCallbackData("A1A2FRE31_BUTTON");
                var A1A2FRE32button = new InlineKeyboardButton();
                A1A2FRE32button.setText("à droite");
                A1A2FRE32button.setCallbackData("A1A2FRE32_BUTTON");
                var A1A2FRE33button = new InlineKeyboardButton();
                A1A2FRE33button.setText("derrière");
                A1A2FRE33button.setCallbackData("A1A2FRE33_BUTTON");
                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(A1A2FRE31button);
                rowInline2.add(A1A2FRE32button); rowInline3.add(A1A2FRE33button);
                rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("A1A2FRE31_BUTTON") || callbackData.equals("A1A2FRE32_BUTTON") || callbackData.equals("A1A2FRE33_BUTTON"))
            {
                if(callbackData.equals("A1A2FRE31_BUTTON"))
                {
                    a2 += 1;
                }
                String text = "Выберите правильное описание погоды. \n Quel temps fait-il aujourd'hui?";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                var A1A2FRE41button = new InlineKeyboardButton();
                A1A2FRE41button.setText("Il fait froid");// правильный ответ
                A1A2FRE41button.setCallbackData("A1A2FRE41_BUTTON");
                var A1A2FRE42button = new InlineKeyboardButton();
                A1A2FRE42button.setText("Il faire froid");
                A1A2FRE42button.setCallbackData("A1A2FRE42_BUTTON");
                var A1A2FRE43button = new InlineKeyboardButton();
                A1A2FRE43button.setText("Il fait chaud");
                A1A2FRE43button.setCallbackData("A1A2FRE43_BUTTON");
                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(A1A2FRE41button);
                rowInline2.add(A1A2FRE42button); rowInline3.add(A1A2FRE43button);
                rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("A1A2FRE41_BUTTON") || callbackData.equals("A1A2FRE42_BUTTON") || callbackData.equals("A1A2FRE43_BUTTON"))
            {
                if(callbackData.equals("A1A2FRE41_BUTTON"))
                {
                    b2 += 1;
                }
                if (a2 == b2 && a2 != 0 && b2 != 0)
                {
                    String text = "Выберите правильное количество. \n Combien de frères et de sœurs as-tu?";
                    EditMessageText message = new EditMessageText();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(text);
                    message.setMessageId((int) messageId);
                    InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                    var A1A2FRE51button = new InlineKeyboardButton();
                    A1A2FRE51button.setText("J'ai trois sœurs");
                    A1A2FRE51button.setCallbackData("A1A2FRE51_BUTTON");
                    var A1A2FRE52button = new InlineKeyboardButton();
                    A1A2FRE52button.setText("J'ai six frères");
                    A1A2FRE52button.setCallbackData("A1A2FRE52_BUTTON");
                    var A1A2FRE53button = new InlineKeyboardButton();
                    A1A2FRE53button.setText("J'ai un frère et une sœur");
                    A1A2FRE53button.setCallbackData("A1A2FRE53_BUTTON");
                    var BACKLANGbutton = new InlineKeyboardButton();
                    BACKLANGbutton.setText("Вернуться к выбору языка");
                    BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                    var BACKLEVELENGbutton = new InlineKeyboardButton();
                    BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                    BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                    rowInline1.add(A1A2FRE51button);
                    rowInline2.add(A1A2FRE52button); rowInline3.add(A1A2FRE53button);
                    rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                    rowsInline.add(rowInline1);
                    rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                    rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                    markupInline.setKeyboard(rowsInline);
                    message.setReplyMarkup(markupInline);
                    exe(message);
                }
                if (a2 == 0 && b2 == 0)
                {
                    messageText("Вы ответили неправильно на все вопросы, рекомендую понизить уровень языка", chatId, messageId);
                }
                else
                {
                    if (a2 < b2)
                    {
                        messageText("Ваш уровень владения французским языком соответствует уровню A2", chatId, messageId);
                    }
                    if (a2 > b2)
                    {
                        messageText("Ваш уровень владения французским языком соответствует уровню A1", chatId, messageId);
                    }
                }

            }
            if(callbackData.equals("A1A2FRE53_BUTTON"))
            {
                messageText("Ваш уровень владения французским языком соответствует уровню A2", chatId, messageId);
            }
            if(callbackData.equals("A1A2FRE51_BUTTON") || callbackData.equals("A1A2FRE52_BUTTON"))
            {
                messageText("Ваш уровень владения французским языком соответствует уровню A1", chatId, messageId);
            }


            if(callbackData.equals("B1B2FRE_BUTTON"))
            {
                c2 = 0;
                d2 = 0;
                String text = "Выберите правильное слово для заполнения пропуска. \n Utilisez le mot correctement dans la phrase : Je suis allé au cinéma (...) regarder un film";
                EditMessageText message = new EditMessageText();
                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                var B1B2FRE11button = new InlineKeyboardButton();
                B1B2FRE11button.setText("pour");// правильный ответ
                B1B2FRE11button.setCallbackData("B1B2FRE11_BUTTON");
                var B1B2FRE12button = new InlineKeyboardButton();
                B1B2FRE12button.setText("à");
                B1B2FRE12button.setCallbackData("B1B2FRE12_BUTTON");
                var B1B2FRE13button = new InlineKeyboardButton();
                B1B2FRE13button.setText("pour");
                B1B2FRE13button.setCallbackData("B1B2FRE13_BUTTON");
                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(B1B2FRE11button);
                rowInline2.add(B1B2FRE12button); rowInline3.add(B1B2FRE13button);
                rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("B1B2FRE11_BUTTON") || callbackData.equals("B1B2FRE12_BUTTON") || callbackData.equals("B1B2FRE13_BUTTON"))
            {
                if(callbackData.equals("B1B2FRE11_BUTTON"))
                {
                    c2 += 1;
                }
                String text = "Выберите правильное предлог для завершения фразы. \n Elle est arrivée  Paris il y a deux semaines";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                var B1B2FRE21button = new InlineKeyboardButton();
                B1B2FRE21button.setText("à");// правильный ответ
                B1B2FRE21button.setCallbackData("B1B2FRE21_BUTTON");
                var B1B2FRE22button = new InlineKeyboardButton();
                B1B2FRE22button.setText("de");
                B1B2FRE22button.setCallbackData("B1B2FRE22_BUTTON");
                var B1B2FRE23button = new InlineKeyboardButton();
                B1B2FRE23button.setText("dans");
                B1B2FRE23button.setCallbackData("B1B2FRE23_BUTTON");
                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(B1B2FRE21button);
                rowInline2.add(B1B2FRE22button); rowInline3.add(B1B2FRE23button);
                rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("B1B2FRE21_BUTTON") || callbackData.equals("B1B2FRE22_BUTTON") || callbackData.equals("B1B2FRE23_BUTTON"))
            {
                if(callbackData.equals("B1B2FRE21_BUTTON"))
                {
                    d2 += 1;
                }
                String text = "Согласуйте глагол partir в будущем времени для нous.";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                var B1B2FRE31button = new InlineKeyboardButton();
                B1B2FRE31button.setText("partira");
                B1B2FRE31button.setCallbackData("B1B2FRE31_BUTTON");
                var B1B2FRE32button = new InlineKeyboardButton();
                B1B2FRE32button.setText("partirez");
                B1B2FRE32button.setCallbackData("B1B2FRE32_BUTTON");
                var B1B2FRE33button = new InlineKeyboardButton();
                B1B2FRE33button.setText("partirons");// правильный ответ
                B1B2FRE33button.setCallbackData("B1B2FRE33_BUTTON");
                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(B1B2FRE31button);
                rowInline2.add(B1B2FRE32button); rowInline3.add(B1B2FRE33button);
                rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("B1B2FRE31_BUTTON") || callbackData.equals("B1B2FRE32_BUTTON") || callbackData.equals("B1B2FRE33_BUTTON"))
            {
                if(callbackData.equals("B1B2FRE33_BUTTON"))
                {
                    c2 += 1;
                }
                String text = "Найдите женский род к слову grand.";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                var B1B2FRE41button = new InlineKeyboardButton();
                B1B2FRE41button.setText("grandeur");
                B1B2FRE41button.setCallbackData("B1B2FRE41_BUTTON");
                var B1B2FRE42button = new InlineKeyboardButton();
                B1B2FRE42button.setText("grande");// правильный ответ
                B1B2FRE42button.setCallbackData("B1B2FRE42_BUTTON");
                var B1B2FRE43button = new InlineKeyboardButton();
                B1B2FRE43button.setText("grandement");
                B1B2FRE43button.setCallbackData("B1B2FRE43_BUTTON");
                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(B1B2FRE41button);
                rowInline2.add(B1B2FRE42button); rowInline3.add(B1B2FRE43button);
                rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("B1B2FRE41_BUTTON") || callbackData.equals("B1B2FRE42_BUTTON") || callbackData.equals("B1B2FRE43_BUTTON"))
            {
                if(callbackData.equals("B1B2FRE42_BUTTON"))
                {
                    d2 += 1;
                }
                if (c2 == d2 && c2 != 0 && d2 != 0)
                {
                    String text = "Выберите правильную форму настоящего сослагательного наклонения глагола être для множественного числа.";
                    EditMessageText message = new EditMessageText();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(text);
                    message.setMessageId((int) messageId);
                    InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                    var B1B2FRE51button = new InlineKeyboardButton();
                    B1B2FRE51button.setText("soyons");
                    B1B2FRE51button.setCallbackData("B1B2FRE51_BUTTON");
                    var B1B2FRE52button = new InlineKeyboardButton();
                    B1B2FRE52button.setText("sommes");
                    B1B2FRE52button.setCallbackData("B1B2FRE52_BUTTON");
                    var B1B2FRE53button = new InlineKeyboardButton();
                    B1B2FRE53button.setText("soient");
                    B1B2FRE53button.setCallbackData("B1B2FRE53_BUTTON");
                    var BACKLANGbutton = new InlineKeyboardButton();
                    BACKLANGbutton.setText("Вернуться к выбору языка");
                    BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                    var BACKLEVELENGbutton = new InlineKeyboardButton();
                    BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                    BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                    rowInline1.add(B1B2FRE51button);
                    rowInline2.add(B1B2FRE52button); rowInline3.add(B1B2FRE53button);
                    rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                    rowsInline.add(rowInline1);
                    rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                    rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                    markupInline.setKeyboard(rowsInline);
                    message.setReplyMarkup(markupInline);
                    exe(message);
                }
                if (c2 == 0 && d2 == 0)
                {
                    messageText("Вы ответили неправильно на все вопросы, рекомендую понизить уровень языка", chatId, messageId);
                }
                else
                {
                    if (c2 < d2)
                    {
                        messageText("Ваш уровень владения французским языком соответствует уровню B2", chatId, messageId);
                    }
                    if (c2 > d2)
                    {
                        messageText("Ваш уровень владения французским языком соответствует уровню B1", chatId, messageId);
                    }
                }
            }
            if(callbackData.equals("B1B2FRE51_BUTTON"))
            {
                messageText("Ваш уровень владения французским языком соответствует уровню B2", chatId, messageId);
            }
            if(callbackData.equals("B1B2FRE52_BUTTON") || callbackData.equals("B1B2FRE53_BUTTON"))
            {
                messageText("Ваш уровень владения французским языком соответствует уровню B1", chatId, messageId);
            }


            if(callbackData.equals("C1C2FRE_BUTTON"))
            {
                i2 = 0;
                f2 = 0;
                String text = "Какое слово использовать в этом предложении: \n l est important de (...) attention à ce que tu dis.";
                EditMessageText message = new EditMessageText();
                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                var C1C2FRE11button = new InlineKeyboardButton();
                C1C2FRE11button.setText("faire");// правильный ответ
                C1C2FRE11button.setCallbackData("C1C2FRE11_BUTTON");
                var C1C2FRE12button = new InlineKeyboardButton();
                C1C2FRE12button.setText("mettre");
                C1C2FRE12button.setCallbackData("C1C2FRE12_BUTTON");
                var C1C2FRE13button = new InlineKeyboardButton();
                C1C2FRE13button.setText("porter");
                C1C2FRE13button.setCallbackData("C1C2FRE13_BUTTON");
                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(C1C2FRE11button);
                rowInline2.add(C1C2FRE12button); rowInline3.add(C1C2FRE13button);
                rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("C1C2FRE11_BUTTON") || callbackData.equals("C1C2FRE12_BUTTON") || callbackData.equals("C1C2FRE13_BUTTON"))
            {
                if(callbackData.equals("C1C2FRE11_BUTTON"))
                {
                    i2 += 1;
                }
                String text = "Какой из представленных времен употребляется для описания действия, которое происходило до другого прошедшего момента времени?";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                var C1C2FRE21button = new InlineKeyboardButton();
                C1C2FRE21button.setText("Le passé composé");
                C1C2FRE21button.setCallbackData("C1C2FRE21_BUTTON");
                var C1C2FRE22button = new InlineKeyboardButton();
                C1C2FRE22button.setText("L'imparfait");// правильный ответ
                C1C2FRE22button.setCallbackData("C1C2FRE22_BUTTON");
                var C1C2FRE23button = new InlineKeyboardButton();
                C1C2FRE23button.setText("Le plus-que-parfait");
                C1C2FRE23button.setCallbackData("C1C2FRE23_BUTTON");
                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(C1C2FRE21button);
                rowInline2.add(C1C2FRE22button); rowInline3.add(C1C2FRE23button);
                rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("C1C2FRE21_BUTTON") || callbackData.equals("C1C2FRE22_BUTTON") || callbackData.equals("C1C2FRE23_BUTTON"))
            {
                if(callbackData.equals("C1C2FRE23_BUTTON"))
                {
                    f2 += 1;
                }
                String text = "Какое слово подходит в этом контексте: \n Je (...) eu l'occasion de visiter Paris plusieurs fois.";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                var C1C2FRE31button = new InlineKeyboardButton();
                C1C2FRE31button.setText("suis");
                C1C2FRE31button.setCallbackData("C1C2FRE31_BUTTON");
                var C1C2FRE32button = new InlineKeyboardButton();
                C1C2FRE32button.setText("ai");// правильный ответ
                C1C2FRE32button.setCallbackData("C1C2FRE32_BUTTON");
                var C1C2FRE33button = new InlineKeyboardButton();
                C1C2FRE33button.setText("avais");
                C1C2FRE33button.setCallbackData("C1C2FRE33_BUTTON");
                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(C1C2FRE31button);
                rowInline2.add(C1C2FRE32button); rowInline3.add(C1C2FRE33button);
                rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("C1C2FRE31_BUTTON") || callbackData.equals("C1C2FRE32_BUTTON") || callbackData.equals("C1C2FRE33_BUTTON"))
            {
                if(callbackData.equals("C1C2FRE32_BUTTON"))
                {
                    i2 += 1;
                }
                String text = "Какое выражение используется для описания события, которое могло произойти, но не случилось?";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                var C1C2FRE41button = new InlineKeyboardButton();
                C1C2FRE41button.setText("Si j'avais su");// правильный ответ
                C1C2FRE41button.setCallbackData("C1C2FRE41_BUTTON");
                var C1C2FRE42button = new InlineKeyboardButton();
                C1C2FRE42button.setText("Si je savais");
                C1C2FRE42button.setCallbackData("C1C2FRE42_BUTTON");
                var C1C2FRE43button = new InlineKeyboardButton();
                C1C2FRE43button.setText("Si j'ai su");
                C1C2FRE43button.setCallbackData("C1C2FRE43_BUTTON");
                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline1.add(C1C2FRE41button);
                rowInline2.add(C1C2FRE42button); rowInline3.add(C1C2FRE43button);
                rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                exe(message);
            }
            if(callbackData.equals("C1C2FRE41_BUTTON") || callbackData.equals("C1C2FRE42_BUTTON") || callbackData.equals("C1C2FRE43_BUTTON"))
            {
                if(callbackData.equals("C1C2FRE41_BUTTON"))
                {
                    f2 += 1;
                }
                if (i2 == f2 && i2 != 0 && f2 != 0)
                {
                    String text = "Какой из следующих видов сослагательного наклонения правильно описывает предположение или желание в настоящем времени?";
                    EditMessageText message = new EditMessageText();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(text);
                    message.setMessageId((int) messageId);

                    InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

                    var C1C2FRE51button = new InlineKeyboardButton();
                    C1C2FRE51button.setText("Le subjonctif imparfait");
                    C1C2FRE51button.setCallbackData("C1C2FRE51_BUTTON");
                    var C1C2FRE52button = new InlineKeyboardButton();
                    C1C2FRE52button.setText("Le subjonctif présent");
                    C1C2FRE52button.setCallbackData("C1C2FRE52_BUTTON");
                    var C1C2FRE53button = new InlineKeyboardButton();
                    C1C2FRE53button.setText("Le subjonctif passé");
                    C1C2FRE53button.setCallbackData("C1C2FRE53_BUTTON");
                    var BACKLANGbutton = new InlineKeyboardButton();
                    BACKLANGbutton.setText("Вернуться к выбору языка");
                    BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                    var BACKLEVELENGbutton = new InlineKeyboardButton();
                    BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                    BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                    rowInline1.add(C1C2FRE51button);
                    rowInline2.add(C1C2FRE52button); rowInline3.add(C1C2FRE53button);
                    rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

                    rowsInline.add(rowInline1);
                    rowsInline.add(rowInline2); rowsInline.add(rowInline3);
                    rowsInline.add(rowInline4); rowsInline.add(rowInline5);

                    markupInline.setKeyboard(rowsInline);
                    message.setReplyMarkup(markupInline);
                    exe(message);
                }
                if (i2 == 0 && f2 == 0)
                {
                    messageText("Вы ответили неправильно на все вопросы, рекомендую понизить уровень языка", chatId, messageId);
                }
                else
                {
                    if (i2 < f2)
                    {
                        messageText("Ваш уровень владения французским языком соответствует уровню С2", chatId, messageId);
                    }
                    if (i2 > f2)
                    {
                        messageText("Ваш уровень владения французским языком соответствует уровню С1", chatId, messageId);
                    }
                }
            }
            if(callbackData.equals("C1C2FRE52_BUTTON"))
            {
                messageText("Ваш уровень владения французским языком соответствует уровню С2", chatId, messageId);
            }
            if(callbackData.equals("C1C2FRE51_BUTTON") || callbackData.equals("C1C2FRE53_BUTTON"))
            {
                messageText("Ваш уровень владения французским языком соответствует уровню С1", chatId, messageId);
            }


            if(callbackData.equals("BACKLANG1_BUTTON"))
            {
                SendMessage message = new SendMessage();
                message.setChatId(String.valueOf(chatId));
                message.setText("Выбери интересующий тебя язык");
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();

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
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();

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
            if(callbackData.equals("BACKLEVELGER_BUTTON"))
            {
                String text = "Выбери тот уровень языка, на который, по твоему мнению, ты знаешь немецкий язык";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int)messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();

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
            if(callbackData.equals("BACKLEVELFRE_BUTTON"))
            {
                String text = "Выбери тот уровень языка, на который, по твоему мнению, ты знаешь французский язык";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int)messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();

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
    public void messageText(String text, long chatId, long messageId)
    {
        EditMessageText message = new EditMessageText();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);
        message.setMessageId((int) messageId);
        exe(message);
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
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

        var A1A2ENG11button = new InlineKeyboardButton();
        A1A2ENG11button.setText("I do Anna");
        A1A2ENG11button.setCallbackData("A1A2ENG11_BUTTON");
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
        rowInline2.add(A1A2ENG12button); rowInline3.add(A1A2ENG13button);
        rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2); rowsInline.add(rowInline3);
        rowsInline.add(rowInline4); rowsInline.add(rowInline5);

        markupInline.setKeyboard(rowsInline);
        message.setReplyMarkup(markupInline);
        exe(message);
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
    public void exe(EditMessageText message)
    {
        try
        {
            execute(message);
        }
        catch (TelegramApiException e)
        {
        }
    }
}