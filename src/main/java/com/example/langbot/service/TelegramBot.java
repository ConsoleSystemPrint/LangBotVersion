package com.example.langbot.service;



import com.example.langbot.config.BotConfig;
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

@Component
public class TelegramBot extends TelegramLongPollingBot {

    final BotConfig config;
    public TelegramBot(BotConfig config) {this.config = config;}
    @Override
    public String getBotUsername() {return config.getBotName();}
    @Override
    public String getBotToken() {return config.getToken();}
    @Override
    public void onUpdateReceived(Update update) //содержит информацию о том что присылается боту
    {
        int k = 0;
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
                List<InlineKeyboardButton> rowInline1 = new ArrayList<>();List<InlineKeyboardButton> rowInline2 = new ArrayList<>();List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
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
                try
                {
                    execute(message);
                }
                catch (TelegramApiException e)
                {
                }



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
                var A1A2GERbutton = new InlineKeyboardButton();
                A1A2GERbutton.setText("Минимальный");
                A1A2GERbutton.setCallbackData("A1A2GER_BUTTON");
                var B1B2GERbutton = new InlineKeyboardButton();
                B1B2GERbutton.setText("Средний");
                B1B2GERbutton.setCallbackData("B1B2GER_BUTTON");
                var C1C2GERbutton = new InlineKeyboardButton();
                C1C2GERbutton.setText("Максимальный");
                C1C2GERbutton.setCallbackData("C1C2GER_BUTTON");
                rowInline.add(A1A2GERbutton);
                rowInline.add(B1B2GERbutton);
                rowInline.add(C1C2GERbutton);
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
                var A1A2FREbutton = new InlineKeyboardButton();
                A1A2FREbutton.setText("Минимальный");
                A1A2FREbutton.setCallbackData("A1A2FRE_BUTTON");
                var B1B2FREbutton = new InlineKeyboardButton();
                B1B2FREbutton.setText("Средний");
                B1B2FREbutton.setCallbackData("B1B2FRE_BUTTON");
                var C1C2FREbutton = new InlineKeyboardButton();
                C1C2FREbutton.setText("Максимальный");
                C1C2FREbutton.setCallbackData("C1C2FRE_BUTTON");
                rowInline.add(A1A2FREbutton);
                rowInline.add(B1B2FREbutton);
                rowInline.add(C1C2FREbutton);
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
            if(callbackData.equals("A1A2ENG_BUTTON")) {
                String text = "Выберите правильный ответ в этом диалоге. Hello! I’m Susanna. What’s your name?";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                var ENG11button = new InlineKeyboardButton();
                ENG11button.setText("I do Anna");
                ENG11button.setCallbackData("ENG11_BUTTON"); // Английский язык первая цифра - первое слово, вторая цифра первый вариант перевода
                var ENG12button = new InlineKeyboardButton();
                ENG12button.setText("My name Anna");
                ENG12button.setCallbackData("ENG12_BUTTON");
                var ENG13button = new InlineKeyboardButton();
                ENG13button.setText("My name is Anna");
                ENG13button.setCallbackData("ENG13_BUTTON");

                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline.add(ENG11button);
                rowInline.add(ENG12button);
                rowInline.add(ENG13button);
                rowInline.add(BACKLANGbutton);
                rowInline.add(BACKLEVELENGbutton);
                rowsInline.add(rowInline);
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                }
            }
            if(callbackData.equals("ENG11_BUTTON")) {
                String text = "Выберите варинт ответа, который должен стоять на месте скобок. How old (...) children?";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                var ENG21button = new InlineKeyboardButton();
                ENG21button.setText("are you");
                ENG21button.setCallbackData("ENG21_BUTTON"); // Английский язык первая цифра - первое слово, вторая цифра первый вариант перевода
                var ENG22button = new InlineKeyboardButton();
                ENG22button.setText("are your");
                ENG22button.setCallbackData("ENG22_BUTTON");
                var ENG23button = new InlineKeyboardButton();
                ENG23button.setText("do you");
                ENG23button.setCallbackData("ENG23_BUTTON");

                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline.add(ENG21button);
                rowInline.add(ENG22button);
                rowInline.add(ENG23button);
                rowInline.add(BACKLANGbutton);
                rowInline.add(BACKLEVELENGbutton);
                rowsInline.add(rowInline);
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                }
            }
            if(callbackData.equals("ENG12_BUTTON")) {
                String text = "Выберите варинт ответа, который должен стоять на месте скобок. How old (...) children?";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                var ENG21button = new InlineKeyboardButton();
                ENG21button.setText("are you");
                ENG21button.setCallbackData("ENG21_BUTTON"); // Английский язык первая цифра - первое слово, вторая цифра первый вариант перевода
                var ENG22button = new InlineKeyboardButton();
                ENG22button.setText("are your");
                ENG22button.setCallbackData("ENG22_BUTTON");
                var ENG23button = new InlineKeyboardButton();
                ENG23button.setText("do you");
                ENG23button.setCallbackData("ENG23_BUTTON");

                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline.add(ENG21button);
                rowInline.add(ENG22button);
                rowInline.add(ENG23button);
                rowInline.add(BACKLANGbutton);
                rowInline.add(BACKLEVELENGbutton);
                rowsInline.add(rowInline);
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                }
            }
            if(callbackData.equals("ENG13_BUTTON")) {
                k += 1;
                String text = "Выберите варинт ответа, который должен стоять на месте скобок. How old (...) children?";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                var ENG21button = new InlineKeyboardButton();
                ENG21button.setText("are you");
                ENG21button.setCallbackData("ENG21_BUTTON"); // Английский язык первая цифра - первое слово, вторая цифра первый вариант перевода
                var ENG22button = new InlineKeyboardButton();
                ENG22button.setText("are your");
                ENG22button.setCallbackData("ENG22_BUTTON");
                var ENG23button = new InlineKeyboardButton();
                ENG23button.setText("do you");
                ENG23button.setCallbackData("ENG23_BUTTON");

                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline.add(ENG21button);
                rowInline.add(ENG22button);
                rowInline.add(ENG23button);
                rowInline.add(BACKLANGbutton);
                rowInline.add(BACKLEVELENGbutton);
                rowsInline.add(rowInline);
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                }
            }
            if(callbackData.equals("ENG21_BUTTON")) {
                String text = "Выберите варинт ответа, который должен стоять на месте скобок. My parents are rich. That’s (...) new house.";
                EditMessageText message = new EditMessageText();

                message.setChatId(String.valueOf(chatId));
                message.setText(text);
                message.setMessageId((int) messageId);
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                var ENG31button = new InlineKeyboardButton();
                ENG31button.setText("our");
                ENG31button.setCallbackData("ENG31_BUTTON"); // Английский язык первая цифра - первое слово, вторая цифра первый вариант перевода
                var ENG32button = new InlineKeyboardButton();
                ENG32button.setText("mine");
                ENG32button.setCallbackData("ENG32_BUTTON");
                var ENG33button = new InlineKeyboardButton();
                ENG33button.setText("theirs");
                ENG33button.setCallbackData("ENG33_BUTTON");

                var BACKLANGbutton = new InlineKeyboardButton();
                BACKLANGbutton.setText("Вернуться к выбору языка");
                BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
                var BACKLEVELENGbutton = new InlineKeyboardButton();
                BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
                BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

                rowInline.add(ENG31button);
                rowInline.add(ENG32button);
                rowInline.add(ENG33button);
                rowInline.add(BACKLANGbutton);
                rowInline.add(BACKLEVELENGbutton);
                rowsInline.add(rowInline);
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                }
            }
            if(callbackData.equals("BACKLANG1_BUTTON"))
            {
                SendMessage message = new SendMessage();
                message.setChatId(String.valueOf(chatId));
                message.setText("Выбери интересующий тебя язык");
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                var ENGbutton = new InlineKeyboardButton();
                ENGbutton.setText("Английский");
                ENGbutton.setCallbackData("ENG_BUTTON");
                var GERbutton = new InlineKeyboardButton();
                GERbutton.setText("Немецкий");
                GERbutton.setCallbackData("GER_BUTTON");
                var FREbutton = new InlineKeyboardButton();
                FREbutton.setText("Французский");
                FREbutton.setCallbackData("FRE_BUTTON");

                rowInline.add(ENGbutton);
                rowInline.add(GERbutton);
                rowInline.add(FREbutton);
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
                var A1A2button = new InlineKeyboardButton();
                A1A2button.setText("Минимальный");
                A1A2button.setCallbackData("A1A2_BUTTON");
                var B1B2button = new InlineKeyboardButton();
                B1B2button.setText("Средний");
                B1B2button.setCallbackData("B1B2_BUTTON");
                var C1C2button = new InlineKeyboardButton();
                C1C2button.setText("Максимальный");
                C1C2button.setCallbackData("C1C2_BUTTON");
                rowInline.add(A1A2button);
                rowInline.add(B1B2button);
                rowInline.add(C1C2button);
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
                var A1A2button = new InlineKeyboardButton();
                A1A2button.setText("Минимальный");
                A1A2button.setCallbackData("A1A2_BUTTON");
                var B1B2button = new InlineKeyboardButton();
                B1B2button.setText("Средний");
                B1B2button.setCallbackData("B1B2_BUTTON");
                var C1C2button = new InlineKeyboardButton();
                C1C2button.setText("Максимальный");
                C1C2button.setCallbackData("C1C2_BUTTON");
                rowInline.add(A1A2button);
                rowInline.add(B1B2button);
                rowInline.add(C1C2button);
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
                var A1A2button = new InlineKeyboardButton();
                A1A2button.setText("Минимальный");
                A1A2button.setCallbackData("A1A2_BUTTON");
                var B1B2button = new InlineKeyboardButton();
                B1B2button.setText("Средний");
                B1B2button.setCallbackData("B1B2_BUTTON");
                var C1C2button = new InlineKeyboardButton();
                C1C2button.setText("Максимальный");
                C1C2button.setCallbackData("C1C2_BUTTON");
                rowInline.add(A1A2button);
                rowInline.add(B1B2button);
                rowInline.add(C1C2button);
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
        var ENGbutton = new InlineKeyboardButton();
        ENGbutton.setText("Английский");
        ENGbutton.setCallbackData("ENG_BUTTON");
        var GERbutton = new InlineKeyboardButton();
        GERbutton.setText("Немецкий");
        GERbutton.setCallbackData("GER_BUTTON");
        var FREbutton = new InlineKeyboardButton();
        FREbutton.setText("Французский");
        FREbutton.setCallbackData("FRE_BUTTON");

        rowInline.add(ENGbutton);
        rowInline.add(GERbutton);
        rowInline.add(FREbutton);



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
