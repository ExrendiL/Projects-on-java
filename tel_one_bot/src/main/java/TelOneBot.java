import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

//import java.util.Comparator;
//import java.util.List;


public class TelOneBot extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {


        //first part
        String command=update.getMessage().getText();
        SendMessage message = new SendMessage();
        if(command.equals("/myname"))
        {
            System.out.println(update.getMessage().getFrom().getFirstName());
            message.setText(update.getMessage().getFrom().getFirstName());
        }
        if (command.equals("/mylastname"))
        {
            System.out.println(update.getMessage().getFrom().getLastName());

            message.setText(update.getMessage().getFrom().getLastName());
        }
        
        if (command.equals("/myfullname"))
        {
            System.out.println(update.getMessage().getFrom().getFirstName()+" "+update.getMessage().getFrom().getLastName());
            message.setText(update.getMessage().getFrom().getFirstName()+" "+update.getMessage().getFrom().getLastName());
        }
        message.setChatId(update.getMessage().getChatId());

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        //second part

        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            SendMessage message1 = new SendMessage() // Create a message object object
                    .setChatId(chat_id)
                    .setText(message_text);
            try {
                execute(message1); // Sending our message object to user
            } catch (TelegramApiException e1) {
                e1.printStackTrace();
            }
        }

        //third part
       // if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
         //  String message_text = update.getMessage().getText();
        //    long chat_id1 = update.getMessage().getChatId1();
         //   SendMessage message2 = new SendMessage() // Create a message object object
            //      .setChatId(chat_id)
           //         .setText(message_text);
          //  try {
       //        execute(message); // Sending our message object to user
        //   } catch (TelegramApiException e) {
       //        e.printStackTrace();
       //     }
     //   }
      //  else if (update.hasMessage() && update.getMessage().hasPhoto()) {
            // Message contains photo
            // Set variables
           // long chat_id = update.getMessage().getChatId();

            // Array with photo objects with different sizes
            // We will get the biggest photo from that array
         //   List<PhotoSize> photos = update.getMessage().getPhoto();
            // Know file_id
         //   String f_id = photos.stream()
             //       .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
           //         .findFirst().orElse(null).getFileId();
            // Know photo width
          //  int f_width = photos.stream()
                //    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                //    .findFirst().orElse(null).getWidth();
            // Know photo height
         //   int f_height = photos.stream()
               //     .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                //    .findFirst().orElse(null).getHeight();
            // Set photo caption
          //  String caption = "file_id: " + f_id + "\nwidth: " + Integer.toString(f_width) + "\nheight: " + Integer.toString(f_height);
         //   SendPhoto msg = new SendPhoto()
              //      .setChatId(chat_id)
              //      .setPhoto(f_id)
              //      .setCaption(caption);
         //   try {
        //        execute(msg); // Call method to send the photo with caption
        //    } catch (TelegramApiException e) {
         //       e.printStackTrace();
        //    }
       // }

    }

    public String getBotUsername() {
        return "tel_one_bot";
    }

    public String getBotToken() {
        return "1214026175:AAHxUWUPziqYklKXq16At2Unw2-wCdI3aTo";
    }
}
