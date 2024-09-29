package com.sparta.kd.chatbotapp.Controllers;

import com.sparta.kd.chatbotapp.Entities.ConversationHistory;
import com.sparta.kd.chatbotapp.Services.ConversationFlowService;
import com.sparta.kd.chatbotapp.Services.ConversationService;
import com.sparta.kd.chatbotapp.Services.FaqService;
import com.sparta.kd.chatbotapp.Utilities.ResponseFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class WebController {

    @Autowired
    private ConversationService conversationService;
    @Autowired
    private FaqService faqService;
    @Autowired
    private ConversationFlowService conversationFlowService;
    @Autowired
    private ResponseFormatter responseFormatter;

    @GetMapping("/chatbot")
    public String getHome(Model model) {
        model.addAttribute("responseMessage", conversationFlowService.getStartMessage());
        model.addAttribute("id", null);
        return "home";
    }

    @PostMapping("/chatbot")
    public String postNewUserInput(@RequestParam("userInput") String userInput, RedirectAttributes redirectAttributes) {
        // Generate a response based on user input
        String responseMessage = responseFormatter.formatFaqResponse(new ArrayList<>(faqService.findMatchingFaqs(userInput)));

        // Create a new chat history list for demonstration
        Integer newId = conversationService.getNewConversationId();
        conversationService.updateCurrentConversationById(newId, userInput, responseMessage);
        ArrayList<ConversationHistory> conversationHistories = new ArrayList<>(conversationService.getCurrentConversationById(newId));

        // Add attributes to the redirect
        redirectAttributes.addFlashAttribute("chatHistory", conversationHistories);
        redirectAttributes.addFlashAttribute("id", newId);
        // Redirect to the /chatbot/{id} endpoint with the newly created chat ID
        return "redirect:/chatbot/" + newId;
    }

    @GetMapping("/chatbot/{id}")
    public String getChatById(@PathVariable("id") int id, Model model) {
        ArrayList<ConversationHistory> conversationHistories = new ArrayList<>(conversationService.getCurrentConversationById(id));

        // Add chat history to the model
        model.addAttribute("chatHistory", conversationHistories);
        model.addAttribute("id", id);
        return "home"; // Return the same view to display the chat history
    }

    @PostMapping("/chatbot/{id}")
    public String postUserInput(@PathVariable("id") int id, Model model, @ModelAttribute("chatHistory") ArrayList<ConversationHistory> conversationHistories, @RequestParam("userInput") String userInput, RedirectAttributes redirectAttributes) {
        // prompt a response
        // update chat history
        // save chat
        // place chat in chatHistory redirect and model attributes

        String responseMessage = responseFormatter.formatFaqResponse(new ArrayList<>(faqService.findMatchingFaqs(userInput)));
        conversationService.updateCurrentConversationById(id, userInput, responseMessage);
        conversationHistories = new ArrayList<>(conversationService.getCurrentConversationById(id));

        redirectAttributes.addFlashAttribute("chatHistory", conversationHistories);
        redirectAttributes.addFlashAttribute("id", id);
        return "redirect:/chatbot/" + id;

    }
}
