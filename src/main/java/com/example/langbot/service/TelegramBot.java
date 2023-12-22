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
                Lang1("Выбери тот уровень языка, на который, по твоему мнению, ты знаешь английский язык",
                        "Минимальный", "A1A2ENG_BUTTON", "Средний", "B1B2ENG_BUTTON",
                        "Максимальный", "C1C2ENG_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("GER_BUTTON"))
            {
                Lang1("Выбери тот уровень языка, на который, по твоему мнению, ты знаешь немецкий язык",
                        "Минимальный", "A1A2GER_BUTTON", "Средний", "B1B2GER_BUTTON",
                        "Максимальный", "C1C2GER_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("FRE_BUTTON"))
            {
                Lang1("Выбери тот уровень языка, на который, по твоему мнению, ты знаешь французский язык",
                        "Минимальный", "A1A2FRE_BUTTON", "Средний", "B1B2FRE_BUTTON",
                        "Максимальный", "C1C2FRE_BUTTON", chatId, messageId);
            }

            if(callbackData.equals("A1A2ENG_BUTTON"))
            {
                a = 0;
                b = 0;
                Lang("Выберите правильный ответ в этом диалоге. \n Hello! I’m Susanna. What’s your name?",
                        "I do Anna", "A1A2ENG11_BUTTON", "My name Anna", "A1A2ENG12_BUTTON",
                        "My name is Anna", "A1A2ENG13_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("A1A2ENG11_BUTTON") || callbackData.equals("A1A2ENG12_BUTTON") || callbackData.equals("A1A2ENG13_BUTTON"))
            {
                if(callbackData.equals("A1A2ENG13_BUTTON"))
                {
                    a += 1;
                }
                Lang("Выберите вариант ответа, который должен стоять на месте скобок. \n My sister's friend is (...) trained teacher.",
                        "the", "A1A2ENG21_BUTTON", "a", "A1A2ENG22_BUTTON",
                        "an", "A1A2ENG23_BUTTON", chatId, messageId);
            }

            if(callbackData.equals("A1A2ENG21_BUTTON") || callbackData.equals("A1A2ENG22_BUTTON") || callbackData.equals("A1A2ENG23_BUTTON"))
            {
                if(callbackData.equals("A1A2ENG22_BUTTON"))
                {
                    b += 1;
                }
                Lang("Выберите вариант ответа, который должен стоять на месте скобок. \n My parents are rich. That’s (...) new house.",
                        "our", "A1A2ENG31_BUTTON", "mine", "A1A2ENG32_BUTTON",
                        "theirs", "A1A2ENG33_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("A1A2ENG31_BUTTON") || callbackData.equals("A1A2ENG32_BUTTON") || callbackData.equals("A1A2ENG33_BUTTON"))
            {
                if(callbackData.equals("A1A2ENG31_BUTTON"))
                {
                    a += 1;
                }
                Lang("Выберите вариант ответа, который должен стоять на месте скобок. \n This is the university (...) i studied economics.",
                        "when", "A1A2ENG41_BUTTON", "where", "A1A2ENG42_BUTTON",
                        "who", "A1A2ENG43_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("A1A2ENG41_BUTTON") || callbackData.equals("A1A2ENG42_BUTTON") || callbackData.equals("A1A2ENG43_BUTTON"))
            {
                if(callbackData.equals("A1A2ENG42_BUTTON"))
                {
                    b += 1;
                }
                if (a == b && a != 0 && b != 0)
                {
                    Lang("Выберите вариант ответа, который должен стоять на месте скобок. \n Where (...) you go on holiday last year?",
                            "do", "A1A2ENG51_BUTTON", "did", "A1A2ENG52_BUTTON",
                            "were", "A1A2ENG53_BUTTON", chatId, messageId);
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
                Lang("Выберите вариант ответа, который должен стоять на месте скобок. \n Please let me (...) the book on the table.",
                        "put", "B1B2ENG11_BUTTON", "to put", "B1B2ENG12_BUTTON",
                        "putting", "B1B2ENG13_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("B1B2ENG11_BUTTON") || callbackData.equals("B1B2ENG12_BUTTON") || callbackData.equals("B1B2ENG13_BUTTON"))
            {
                if(callbackData.equals("B1B2ENG11_BUTTON"))
                {
                    c += 1;
                }
                Lang("Выберите вариант ответа, который должен стоять на месте скобок. \n She is interested (...) learning Spanish and French.",
                        "in", "B1B2ENG21_BUTTON", "on", "B1B2ENG22_BUTTON",
                        "at", "B1B2ENG23_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("B1B2ENG21_BUTTON") || callbackData.equals("B1B2ENG22_BUTTON") || callbackData.equals("B1B2ENG23_BUTTON"))
            {
                if(callbackData.equals("B1B2ENG21_BUTTON"))
                {
                    d += 1;
                }
                Lang("Выберите вариант ответа, который должен стоять на месте скобок. \n I am excited (...) my new job next week.",
                        "start", "B1B2ENG31_BUTTON", "to start", "B1B2ENG32_BUTTON",
                        "started", "B1B2ENG33_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("B1B2ENG31_BUTTON") || callbackData.equals("B1B2ENG32_BUTTON") || callbackData.equals("B1B2ENG33_BUTTON"))
            {
                if(callbackData.equals("B1B2ENG32_BUTTON"))
                {
                    c += 1;
                }
                Lang("Выберите вариант ответа, который должен стоять на месте скобок. \n My brother has been living in Berlin (...) over five years.",
                        "from", "B1B2ENG41_BUTTON", "at", "B1B2ENG42_BUTTON",
                        "for", "B1B2ENG43_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("B1B2ENG41_BUTTON") || callbackData.equals("B1B2ENG42_BUTTON") || callbackData.equals("B1B2ENG43_BUTTON"))
            {
                if(callbackData.equals("B1B2ENG43_BUTTON"))
                {
                    d += 1;
                }
                if (c == d && c != 0 && d != 0)
                {
                    Lang("Выберите вариант ответа, который должен стоять на месте скобок. \n I couldn't go to the party because I (...) my project.",
                            "have finished", "B1B2ENG51_BUTTON", "must finish", "B1B2ENG52_BUTTON",
                            "had to finish", "B1B2ENG53_BUTTON", chatId, messageId);
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
                Lang("Выберите вариант ответа, который должен стоять на месте скобок. \n She is very good (...) playing the piano.",
                        "for", "C1C2ENG11_BUTTON", "at", "C1C2ENG12_BUTTON",
                        "in", "C1C2ENG13_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("C1C2ENG11_BUTTON") || callbackData.equals("C1C2ENG12_BUTTON") || callbackData.equals("C1C2ENG13_BUTTON"))
            {
                if(callbackData.equals("C1C2ENG12_BUTTON"))
                {
                    i += 1;
                }
                Lang("Выберите вариант ответа, который должен стоять на месте скобок. \n I am not familiar (...) the new system yet.",
                        "with", "C1C2ENG21_BUTTON", "by", "C1C2ENG22_BUTTON",
                        "to", "C1C2ENG23_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("C1C2ENG21_BUTTON") || callbackData.equals("C1C2ENG22_BUTTON") || callbackData.equals("C1C2ENG23_BUTTON"))
            {

                if(callbackData.equals("C1C2ENG21_BUTTON"))
                {
                    f += 1;
                }
                Lang("Выберите вариант ответа, который должен стоять на месте скобок. \n I can't believe you (...) the concert last night!",
                        "missed", "C1C2ENG31_BUTTON", "lost", "C1C2ENG32_BUTTON",
                        "skip", "C1C2ENG33_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("C1C2ENG31_BUTTON") || callbackData.equals("C1C2ENG32_BUTTON") || callbackData.equals("C1C2ENG33_BUTTON"))
            {
                if(callbackData.equals("C1C2ENG31_BUTTON"))
                {
                    i += 1;
                }
                Lang("Выберите вариант ответа, который должен стоять на месте скобок. \n It was (...) she received the news that she had won the award.",
                        "scarcely", "C1C2ENG41_BUTTON", "hardly", "C1C2ENG42_BUTTON",
                        "just", "C1C2ENG43_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("C1C2ENG41_BUTTON") || callbackData.equals("C1C2ENG42_BUTTON") || callbackData.equals("C1C2ENG43_BUTTON"))
            {
                if(callbackData.equals("C1C2ENG43_BUTTON"))
                {
                    f += 1;
                }
                if (i == f && i != 0 && f != 0)
                {
                    Lang("Выберите вариант ответа, который должен стоять на месте скобок. \n (...) he considered his options, he made the decision to resign.",
                            "Although", "C1C2ENG51_BUTTON", "Despite", "C1C2ENG52_BUTTON",
                            "Nevertheless", "C1C2ENG53_BUTTON", chatId, messageId);
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
                Lang("Выберите вариант ответа, который должен стоять на месте скобок. \n Vervollständige den Satz: Ich (…) gut.",
                        "ist", "A1A2GER11_BUTTON", "bin", "A1A2GER12_BUTTON",
                        "bist", "A1A2GER13_BUTTON", chatId, messageId);
            }

            if(callbackData.equals("A1A2GER11_BUTTON") || callbackData.equals("A1A2GER12_BUTTON") || callbackData.equals("A1A2GER13_BUTTON")) {
                if (callbackData.equals("A1A2GER12_BUTTON"))
                {
                    a1 += 1 ;
                }
                {
                    Lang("Выберите вариант ответа, который должен стоять на месте скобок. \n Setze das richtige Wort ein: Wir gehen (...)",
                            "schwimmen", "A1A2GER21_BUTTON", "schwimmst", "A1A2GER22_BUTTON",
                            "schwimmt", "A1A2GER23_BUTTON", chatId, messageId);
                }
            }
            if(callbackData.equals("A1A2GER21_BUTTON") || callbackData.equals("A1A2GER22_BUTTON") || callbackData.equals("A1A2GER23_BUTTON"))
            {

                if(callbackData.equals("A1A2GER21_BUTTON"))
                {
                    b1 += 1;
                }
                Lang("Выберите вариант ответа, который должен стоять на месте скобок. \n Welches Wort passt? Sie (...) Lehrerin",
                        "bin", "A1A2GER31_BUTTON", "sind", "A1A2GER32_BUTTON",
                        "ist", "A1A2GER33_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("A1A2GER31_BUTTON") || callbackData.equals("A1A2GER32_BUTTON") || callbackData.equals("A1A2GER33_BUTTON"))
            {
                if(callbackData.equals("A1A2GER33_BUTTON"))
                {
                    a1 += 1;
                }
                Lang("Выберите вариант ответа, который должен стоять на месте скобок. \n Wann bist du (...) Berlin gekommen?",
                        "in", "A1A2GER41_BUTTON", "nach", "A1A2GER42_BUTTON",
                        "auf", "A1A2GER43_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("A1A2GER41_BUTTON") || callbackData.equals("A1A2GER42_BUTTON") || callbackData.equals("A1A2GER43_BUTTON"))
            {
                if(callbackData.equals("A1A2GER42_BUTTON"))
                {
                    b1 += 1;
                }
                if (a1 == b1 && a1 != 0 && b1 != 0)
                {
                    Lang("Образуйте причастие от слова machen.",
                            "gemacht", "A1A2GER51_BUTTON", "machtest", "A1A2GER52_BUTTON",
                            "macht", "A1A2GER53_BUTTON", chatId, messageId);
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
                Lang("Как правильно использовать слово в этом предложении? \n Ich bin (...) in die Stadt gegangen.",
                        "gern", "B1B2GER11_BUTTON", "oft", "B1B2GER12_BUTTON",
                        "allein", "B1B2GER13_BUTTON", chatId, messageId);
            }

            if(callbackData.equals("B1B2GER11_BUTTON") || callbackData.equals("B1B2GER12_BUTTON") || callbackData.equals("B1B2GER13_BUTTON"))
            {
                if (callbackData.equals("B1B2GER13_BUTTON"))
                {
                    c1 += 1 ;
                }
                {
                    Lang("Какое выражение используется для выражения своего мнения на счет чего-либо?",
                            "Ich denke, dass", "B1B2GER21_BUTTON", "Es scheint mir, dass", "B1B2GER22_BUTTON",
                            "Mir gefällt, dass", "B1B2GER23_BUTTON", chatId, messageId);
                }
            }
            if(callbackData.equals("B1B2GER21_BUTTON") || callbackData.equals("B1B2GER22_BUTTON") || callbackData.equals("B1B2GER23_BUTTON"))
            {
                if(callbackData.equals("B1B2GER21_BUTTON"))
                {
                    d1 += 1;
                }
                Lang("Какое слово подходит в этом контексте \n Am Wochenende (...) ich gerne ins Kino.",
                        "gehe", "B1B2GER31_BUTTON", "geht", "B1B2GER32_BUTTON",
                        "gehen", "B1B2GER33_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("B1B2GER31_BUTTON") || callbackData.equals("B1B2GER32_BUTTON") || callbackData.equals("B1B2GER33_BUTTON"))
            {
                if(callbackData.equals("B1B2GER31_BUTTON"))
                {
                    c1 += 1;
                }
                Lang("Какой предлог используется с глаголом warten в значении ждать кого-то?",
                        "an", "B1B2GER41_BUTTON", "auf", "B1B2GER42_BUTTON",
                        "vor", "B1B2GER43_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("B1B2GER41_BUTTON") || callbackData.equals("B1B2GER42_BUTTON") || callbackData.equals("B1B2GER43_BUTTON"))
            {
                if(callbackData.equals("B1B2GER42_BUTTON"))
                {
                    d1 += 1;
                }
                if (c1 == d1 && c1 != 0 && d1 != 0)
                {
                    Lang("Какая форма причастия употребляется в составе сложного прошедшего времени с глаголом haben?",
                            "Partizip I", "B1B2GER51_BUTTON", "Partizip II", "B1B2GER52_BUTTON",
                            "Partizip III", "B1B2GER53_BUTTON", chatId, messageId);
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
                Lang("Какая форма глагола используется в сослагательном наклонении во времени Praeteritum Perfekt?",
                        "Konjunktiv I", "C1C2GER11_BUTTON", "Konjunktiv II", "C1C2GER12_BUTTON",
                        "Konjunktiv III", "C1C2GER13_BUTTON", chatId, messageId);
            }

            if(callbackData.equals("C1C2GER11_BUTTON") || callbackData.equals("C1C2GER12_BUTTON") || callbackData.equals("C1C2GER13_BUTTON"))
            {
                if (callbackData.equals("C1C2GER12_BUTTON"))
                {
                    i1 += 1 ;
                }
                {
                    Lang("Какой из следующих случаев употребления Konjunktiv I является правильным?",
                            "Zum Ausdruck von Möglichkeiten und Annahmen", "C1C2GER21_BUTTON", "Für indirekte Rede", "C1C2GER22_BUTTON",
                            "Im Alltag für die Höflichkeitsformen", "C1C2GER23_BUTTON", chatId, messageId);
                }
            }
            if(callbackData.equals("C1C2GER21_BUTTON") || callbackData.equals("C1C2GER22_BUTTON") || callbackData.equals("C1C2GER23_BUTTON"))
            {

                if(callbackData.equals("C1C2GER22_BUTTON"))
                {
                    f1 += 1;
                }
                Lang("Какое слово использовать в этом предложении? \n As war (...) Niederlage, aber sie hat tapfer gekämpft.",
                        "keine", "C1C2GER31_BUTTON", "irgendeine", "C1C2GER32_BUTTON",
                        "eine", "C1C2GER33_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("C1C2GER31_BUTTON") || callbackData.equals("C1C2GER32_BUTTON") || callbackData.equals("C1C2GER33_BUTTON"))
            {
                if(callbackData.equals("C1C2GER33_BUTTON"))
                {
                    i1 += 1;
                }
                Lang("Какой падеж используется после предлога wegen?",
                        "Dativ", "C1C2GER41_BUTTON", "Akkusativ", "C1C2GER42_BUTTON",
                        "Genitiv", "C1C2GER43_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("C1C2GER41_BUTTON") || callbackData.equals("C1C2GER42_BUTTON") || callbackData.equals("C1C2GER43_BUTTON"))
            {
                if(callbackData.equals("C1C2GER43_BUTTON"))
                {
                    f1 += 1;
                }
                if (i1 == f1 && i1 != 0 && f1 != 0)
                {
                    Lang("Какая форма времени Kant haben Plusquamperfekt состоит из глагола haben и причастия II основного глагола?",
                            "Konditional II", "C1C2GER51_BUTTON", "Futur II", "C1C2GER52_BUTTON",
                            "Konjunktiv II", "C1C2GER53_BUTTON", chatId, messageId);
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
                Lang("Выберите правильный цвет. \n Quelle est la couleur du ciel?",
                        "bleu", "A1A2FRE11_BUTTON", "rouge", "A1A2FRE12_BUTTON",
                        "jaune", "A1A2FRE13_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("A1A2FRE11_BUTTON") || callbackData.equals("A1A2FRE12_BUTTON") || callbackData.equals("A1A2FRE13_BUTTON"))
            {
                if(callbackData.equals("A1A2FRE11_BUTTON"))
                {
                    a2 += 1;
                }
                Lang("Выберите правильную форму будущего времени глагола aller. \n Qu'est-ce que tu vas faire ce weekend?",
                        "Je aller au cinéma", "A1A2FRE21_BUTTON", "e vais au cinéma", "A1A2FRE22_BUTTON",
                        "Je vais à la cinéma", "A1A2FRE23_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("A1A2FRE21_BUTTON") || callbackData.equals("A1A2FRE22_BUTTON") || callbackData.equals("A1A2FRE23_BUTTON"))
            {
                if(callbackData.equals("A1A2FRE22_BUTTON"))
                {
                    b2 += 1;
                }
                Lang("Выберите правильное местоположение. \n Où est la bibliothèque?",
                        "à gauche", "A1A2FRE31_BUTTON", "à droite", "A1A2FRE32_BUTTON",
                        "derrière", "A1A2FRE33_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("A1A2FRE31_BUTTON") || callbackData.equals("A1A2FRE32_BUTTON") || callbackData.equals("A1A2FRE33_BUTTON"))
            {
                if(callbackData.equals("A1A2FRE31_BUTTON"))
                {
                    a2 += 1;
                }
                Lang("Выберите правильное описание погоды. \n Quel temps fait-il aujourd'hui?",
                        "Il fait froid", "A1A2FRE41_BUTTON", "Il faire froid", "A1A2FRE42_BUTTON",
                        "Il fait chaud", "A1A2FRE43_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("A1A2FRE41_BUTTON") || callbackData.equals("A1A2FRE42_BUTTON") || callbackData.equals("A1A2FRE43_BUTTON"))
            {
                if(callbackData.equals("A1A2FRE41_BUTTON"))
                {
                    b2 += 1;
                }
                if (a2 == b2 && a2 != 0 && b2 != 0)
                {
                    Lang("Выберите правильное количество. \n Combien de frères et de sœurs as-tu?",
                            "J'ai trois sœurs", "A1A2FRE51_BUTTON", "J'ai six frères", "A1A2FRE52_BUTTON",
                            "J'ai un frère et une sœur", "A1A2FRE53_BUTTON", chatId, messageId);
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
                Lang("Выберите правильное слово для заполнения пропуска. \n Utilisez le mot correctement dans la phrase : Je suis allé au cinéma (...) regarder un film",
                        "pour", "B1B2FRE11_BUTTON", "à", "B1B2FRE12_BUTTON",
                        "pour", "B1B2FRE13_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("B1B2FRE11_BUTTON") || callbackData.equals("B1B2FRE12_BUTTON") || callbackData.equals("B1B2FRE13_BUTTON"))
            {
                if(callbackData.equals("B1B2FRE11_BUTTON"))
                {
                    c2 += 1;
                }
                Lang("Выберите правильное предлог для завершения фразы. \n Elle est arrivée  Paris il y a deux semaines",
                        "à", "B1B2FRE21_BUTTON", "de", "B1B2FRE22_BUTTON",
                        "dans", "B1B2FRE23_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("B1B2FRE21_BUTTON") || callbackData.equals("B1B2FRE22_BUTTON") || callbackData.equals("B1B2FRE23_BUTTON"))
            {
                if(callbackData.equals("B1B2FRE21_BUTTON"))
                {
                    d2 += 1;
                }
                Lang("Согласуйте глагол partir в будущем времени для нous.",
                        "partira", "B1B2FRE31_BUTTON", "partirez", "B1B2FRE32_BUTTON",
                        "partirons", "B1B2FRE33_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("B1B2FRE31_BUTTON") || callbackData.equals("B1B2FRE32_BUTTON") || callbackData.equals("B1B2FRE33_BUTTON"))
            {
                if(callbackData.equals("B1B2FRE33_BUTTON"))
                {
                    c2 += 1;
                }
                Lang("айдите женский род к слову grand.",
                        "grandeur", "B1B2FRE41_BUTTON", "grande", "B1B2FRE42_BUTTON",
                        "grandement", "B1B2FRE43_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("B1B2FRE41_BUTTON") || callbackData.equals("B1B2FRE42_BUTTON") || callbackData.equals("B1B2FRE43_BUTTON"))
            {
                if(callbackData.equals("B1B2FRE42_BUTTON"))
                {
                    d2 += 1;
                }
                if (c2 == d2 && c2 != 0 && d2 != 0)
                {
                    Lang("Выберите правильную форму настоящего сослагательного наклонения глагола être для множественного числа.",
                            "soyons", "B1B2FRE51_BUTTON", "sommes", "B1B2FRE52_BUTTON",
                            "soient", "B1B2FRE53_BUTTON", chatId, messageId);
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
                Lang("Какое слово использовать в этом предложении: \n l est important de (...) attention à ce que tu dis.",
                        "faire", "C1C2FRE11_BUTTON", "mettre", "C1C2FRE12_BUTTON",
                        "porter", "C1C2FRE13_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("C1C2FRE11_BUTTON") || callbackData.equals("C1C2FRE12_BUTTON") || callbackData.equals("C1C2FRE13_BUTTON"))
            {
                if(callbackData.equals("C1C2FRE11_BUTTON"))
                {
                    i2 += 1;
                }
                Lang("Какой из представленных времен употребляется для описания действия, которое происходило до другого прошедшего момента времени?",
                        "Le passé composé", "C1C2FRE21_BUTTON", "L'imparfait", "C1C2FRE22_BUTTON",
                        "Le plus-que-parfait", "C1C2FRE23_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("C1C2FRE21_BUTTON") || callbackData.equals("C1C2FRE22_BUTTON") || callbackData.equals("C1C2FRE23_BUTTON"))
            {
                if(callbackData.equals("C1C2FRE23_BUTTON"))
                {
                    f2 += 1;
                }
                Lang("Какое слово подходит в этом контексте: \n Je (...) eu l'occasion de visiter Paris plusieurs fois.",
                        "suis", "C1C2FRE31_BUTTON", "ai", "C1C2FRE32_BUTTON",
                        "avais", "C1C2FRE33_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("C1C2FRE31_BUTTON") || callbackData.equals("C1C2FRE32_BUTTON") || callbackData.equals("C1C2FRE33_BUTTON"))
            {
                if(callbackData.equals("C1C2FRE32_BUTTON"))
                {
                    i2 += 1;
                }
                Lang("Какое выражение используется для описания события, которое могло произойти, но не случилось?",
                        "Si j'avais su", "C1C2FRE41_BUTTON", "Si je savais", "C1C2FRE42_BUTTON",
                        "Si j'ai su", "C1C2FRE43_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("C1C2FRE41_BUTTON") || callbackData.equals("C1C2FRE42_BUTTON") || callbackData.equals("C1C2FRE43_BUTTON"))
            {
                if(callbackData.equals("C1C2FRE41_BUTTON"))
                {
                    f2 += 1;
                }
                if (i2 == f2 && i2 != 0 && f2 != 0)
                {
                    Lang("Какой из следующих видов сослагательного наклонения правильно описывает предположение или желание в настоящем времени?",
                            "Le subjonctif imparfait", "C1C2FRE51_BUTTON", "Le subjonctif présent", "C1C2FRE52_BUTTON",
                            "Le subjonctif passé", "C1C2FRE53_BUTTON", chatId, messageId);
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
                Lang1("Выбери интересующий тебя язык",
                        "Английский", "ENG_BUTTON", "Немецкий", "GER_BUTTON",
                        "Французский", "FRE_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("BACKLEVELENG_BUTTON"))
            {
                Lang1("Выбери тот уровень языка, на который, по твоему мнению, ты знаешь английский язык",
                        "Минимальный", "A1A2_BUTTON", "Средний", "B1B2_BUTTON",
                        "Максимальный", "C1C2_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("BACKLEVELGER_BUTTON"))
            {
                Lang1("Выбери тот уровень языка, на который, по твоему мнению, ты знаешь немецкий язык",
                        "Минимальный", "A1A2_BUTTON", "Средний", "B1B2_BUTTON",
                        "Максимальный", "C1C2_BUTTON", chatId, messageId);
            }
            if(callbackData.equals("BACKLEVELFRE_BUTTON"))
            {
                Lang1("Выбери тот уровень языка, на который, по твоему мнению, ты знаешь французский язык",
                        "Минимальный", "A1A2_BUTTON", "Средний", "B1B2_BUTTON",
                        "Максимальный", "C1C2_BUTTON", chatId, messageId);
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
            System.out.println("error" + e.getMessage());
        }
    }
    public void Lang(String text, String s1, String data1, String s2, String data2, String s3, String data3, long chatId, long messageId)
    {
        EditMessageText message = new EditMessageText();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);
        System.out.println( message.getText());

        message.setMessageId((int) messageId);
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline4 = new ArrayList<>(); List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

        var customButton1 = new InlineKeyboardButton();
        customButton1.setText(s1);
        customButton1.setCallbackData(data1);
        var customButton2 = new InlineKeyboardButton();
        customButton2.setText(s2);
        customButton2.setCallbackData(data2);
        var customButton3 = new InlineKeyboardButton();
        customButton3.setText(s3);
        customButton3.setCallbackData(data3);

        var BACKLANGbutton = new InlineKeyboardButton();
        BACKLANGbutton.setText("Вернуться к выбору языка");
        BACKLANGbutton.setCallbackData("BACKLANG1_BUTTON");
        var BACKLEVELENGbutton = new InlineKeyboardButton();
        BACKLEVELENGbutton.setText("Вернуться к выбору уровня языка");
        BACKLEVELENGbutton.setCallbackData("BACKLEVELENG_BUTTON");

        rowInline1.add(customButton1);
        rowInline2.add(customButton2); rowInline3.add(customButton3);
        rowInline4.add(BACKLANGbutton); rowInline5.add(BACKLEVELENGbutton);

        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2); rowsInline.add(rowInline3);
        rowsInline.add(rowInline4); rowsInline.add(rowInline5);

        markupInline.setKeyboard(rowsInline);
        message.setReplyMarkup(markupInline);
        exe(message);
    }
    public void Lang1(String text, String s1, String data1, String s2, String data2, String s3, String data3, long chatId, long messageId)
    {
        EditMessageText message = new EditMessageText();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);
        System.out.println(message.getText());
        message.setMessageId((int) messageId);
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>(); List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline2 = new ArrayList<>(); List<InlineKeyboardButton> rowInline3 = new ArrayList<>();

        var customButton1 = new InlineKeyboardButton();
        customButton1.setText(s1);
        customButton1.setCallbackData(data1);
        var customButton2 = new InlineKeyboardButton();
        customButton2.setText(s2);
        customButton2.setCallbackData(data2);
        var customButton3 = new InlineKeyboardButton();
        customButton3.setText(s3);
        customButton3.setCallbackData(data3);

        rowInline1.add(customButton1);
        rowInline2.add(customButton2); rowInline3.add(customButton3);

        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2); rowsInline.add(rowInline3);

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
            System.out.println("error" + e.getMessage());
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
            System.out.println("error" + e.getMessage());
        }
    }
}
