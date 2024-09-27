package com.sparta.kd.chatbotapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chatbot")
public class WebController {

    @Autowired


    @GetMapping
    public String getHome(Model model) {
        model.addAttribute("responseMessage", "How can I help?");
        return "home";
    }

    @PostMapping
    public String processUserInput(@RequestParam("userInput") String userInput, RedirectAttributes redirectAttributes) {
        // Generate a response based on user input
        String responseMessage = generateResponse(userInput);

        // Create a new chat history list for demonstration
        List<String> newChatHistory = new ArrayList<>();
        newChatHistory.add("User: " + userInput);
        newChatHistory.add("Bot: " + responseMessage);

        // Store the chat history in a mock "database" and get the unique ID
        int chatId = chatHistoryDatabase.size();
        chatHistoryDatabase.add(newChatHistory);

        // Add attributes to the redirect
        redirectAttributes.addFlashAttribute("chatHistory", newChatHistory);
        redirectAttributes.addFlashAttribute("responseMessage", responseMessage);

        // Redirect to the /chatbot/{id} endpoint with the newly created chat ID
        return "redirect:/chatbot/" + chatId;
    }

    @GetMapping("/{id}")
    public String getChatById(@PathVariable("id") int id, Model model, @ModelAttribute("chatHistory") List<String> chatHistory) {
        // If chatHistory is not present (e.g., accessing directly), fetch it from the "database"
        if (chatHistory == null || chatHistory.isEmpty()) {
            chatHistory = id < chatHistoryDatabase.size() ? chatHistoryDatabase.get(id) : new ArrayList<>();
        }

        // Add chat history to the model
        model.addAttribute("chatHistory", chatHistory);
        model.addAttribute("responseMessage", "Viewing chat history for session ID: " + id);

        return "home"; // Return the same view to display the chat history
    }

    // Example method to generate a response based on user input
    private String generateResponse(String userInput) {
        if (userInput.equalsIgnoreCase("hello")) {
            return "Hello! How can I assist you today?";
        } else {
            return "I'm not sure how to respond to that. Can you ask something else?";
        }
    }
}
