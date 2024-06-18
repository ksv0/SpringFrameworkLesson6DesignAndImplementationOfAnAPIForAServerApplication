package ru.gb.ksv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;
@Configuration
public class IntegrationConfig {

    @Bean
    public MessageChannel textInputChannel(){
        return new DirectChannel();
    }


    @Bean
    public MessageChannel fileWriterChannel(){
        return new DirectChannel();
    }

    @Bean
    @Transformer(inputChannel = "textInputChannel",outputChannel = "fileWriterChannel")
    public GenericTransformer<String, String> myTransformer(){
        return text -> text.toUpperCase().trim();
    }

    @Bean
    @ServiceActivator(inputChannel = "fileWriterChannel")
    public FileWritingMessageHandler meMessageHandler() {
        File outputDirectory = new File("./output"); // Create a directory named "output" in your project root
        if (!outputDirectory.exists()) {
            outputDirectory.mkdir(); // Create the directory if it doesn't exist
        }

        FileWritingMessageHandler handler = new FileWritingMessageHandler(outputDirectory);
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);
        return handler;
    }
}
