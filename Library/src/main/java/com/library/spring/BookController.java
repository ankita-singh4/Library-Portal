package com.library.spring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

import com.library.spring.model.Book;
import com.library.spring.model.Status;
import com.library.spring.model.Users;
import com.library.spring.service.BookService;


@Controller
public class BookController {
	
private BookService bookService;
	
	@Autowired(required=true)
	@Qualifier(value="bookService")
	public void setPersonService(BookService bs){
		this.bookService = bs;
	}
	
	@RequestMapping(value = "/addbook", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("book", new Book());
		
		return "addbook";
	}
	
	/*
	@RequestMapping(value = "/removebook", method = RequestMethod.GET)
	public String listPersonsr(Model model) {
		model.addAttribute("rmbook", new Book());
		
		return "removebook";
	}
	*/
	@RequestMapping(value = "/removebook", method = RequestMethod.GET)
	public String showForm(Map model) {
		Book rmbook = new Book();
		model.put("rmbook", rmbook);
		return "removebook";
	}
	
	/*
	
	public String addPerson(@ModelAttribute("person") @Valid Person p,BindingResult result, Model model){
		
		
		if (result.hasErrors())
		{
			System.out.println("Validation Error");
			return "person";
		}
	*/
	
	
	int booknumber=0;
	//For add and update person both
	@RequestMapping(value= "/addbook/add", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("book") @Valid Book b,BindingResult result, Model model){
	//public String addBook(@ModelAttribute("book") Book b,BindingResult result, Model model){
		if (result.hasErrors())
		{
			System.out.println("Form Validation Failed");
			return "redirect:/addbook";
		}
		
		else{
			
			if(b.getId() == 0){
				System.out.println(b.getBookName());
			//new person, add it
			this.bookService.addBook(b);
			}
		
		else{
			//existing person, call update
			//this.personService.updatePerson(p);
			System.out.println("Inside Else");
			}
		
		return "redirect:/staffhome";
		}
	}
	
	
	@RequestMapping(value = "/removebook", method = RequestMethod.POST)
	public String processForm(Book rmbook, BindingResult result,
			Map model) {

		
		if (result.hasErrors()) {
			return "removebook";
		}
		
		boolean bookExists = this.bookService.checkBook(rmbook.getId());
		System.out.println(bookExists);
		
		if (bookExists)
		{
			System.out.println("BOOK EXISTS");
			model.put("rmbook", rmbook);
			System.out.println(rmbook.getId());
			booknumber=rmbook.getId();
			
			//return "confirmremove";
			return "redirect:/confirm";
			
		}
		
		else
		{
			System.out.println("BOOK IS NOT AVAILABLE");
			model.put("rmbook", rmbook);
			System.out.println(rmbook.getId());
			return "removebook";
		}
		
	}
	
	@RequestMapping("/yesremove")
    public String removeYesBook(){
		
		System.out.println("InsideYesRemove");
        //this.bookService.removeBook(id);
		System.out.println(booknumber);
		this.bookService.removeBook(booknumber);
        return "staffpage";
    }
	
	
	@RequestMapping("/noremove")
    public String removeNoBook(){
		System.out.println("InsideNORemove");
        //this.bookService.removeBook(id);
        return "staffpage";
    }
	
	@RequestMapping("/staffhome")
    public String showStaffHome(){
		
		System.out.println("Inside Staff Home ");
        
        return "staffpage";
    }
	
	@RequestMapping("/confirm")
    public String showConfirmPage(Model model){
		
		System.out.println("Inside confirm page ");
        
		Book book = this.bookService.getBookById(booknumber);
		System.out.println(book.getBookName());
		System.out.println(book.getBookAuthor());
		System.out.println(book.getBookGenre());
		System.out.println(book.getBookISBN());
		
		model.addAttribute("bookName", book.getBookName());
		model.addAttribute("bookAuthor", book.getBookAuthor() );
		model.addAttribute("bookGenre", book.getBookGenre() );
		model.addAttribute("bookISBN", book.getBookISBN() );
		
        return "confirmremove";
    }
	

	
	
 
}
