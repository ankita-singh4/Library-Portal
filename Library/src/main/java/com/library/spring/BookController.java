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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping(value = "/removebook", method = RequestMethod.GET)
	public String showForm(Map model) {
		Book rmbook = new Book();
		model.put("rmbook", rmbook);
		return "removebook";
	}
	
	
	int booknumber=0;
	@RequestMapping(value= "/addbook/add", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("book") @Valid Book b,BindingResult result, Model model){
	//public String addBook(@ModelAttribute("book") Book b,BindingResult result, Model model){
		if (result.hasErrors())
		{
			System.out.println("Form Validation Failed");
			return "redirect:/addbook";
		}
		
		else{
			
			if(b.getBookId() == 0){
				System.out.println(b.getBookName());
			this.bookService.addBook(b);
			}
		
		else{
			System.out.println("Inside Else");
			}
		
		return "redirect:/staffhome";
		}
	}
	
	@RequestMapping(value = "/updatebook", method = RequestMethod.GET)
	public String showUpdateForm(Map model) {
		Book rmbook = new Book();
		model.put("rmbook", rmbook);
		
		return "updatebook";
	}
	
	@RequestMapping(value = "/removebook", method = RequestMethod.POST)
	public String processForm(Book rmbook, BindingResult result,
			Map model) {

		
		if (result.hasErrors()) {
			return "removebook";
		}
		
		boolean bookExists = this.bookService.checkBook(rmbook.getBookId());
		System.out.println(bookExists);
		
		if (bookExists)
		{
			System.out.println("BOOK EXISTS");
			model.put("rmbook", rmbook);
			System.out.println(rmbook.getBookId());
			booknumber=rmbook.getBookId();
			
			//return "confirmremove";
			return "redirect:/confirm";
			
		}
		
		else
		{
			System.out.println("BOOK IS NOT AVAILABLE");
			model.put("rmbook", rmbook);
			System.out.println(rmbook.getBookId());
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
    public String showStaffHome(Model model, RedirectAttributes redirectAttributes){
		
		System.out.println("Inside Staff Home ");
		Users user = new Users();
		user.setUserType("Customer");
		redirectAttributes.addFlashAttribute("user", user);
        
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
	
	@RequestMapping(value = "/updatebook", method = RequestMethod.POST)
	public String processUpdateForm(Book rmbook, BindingResult result,
			Model model) {
		
		model.addAttribute("rmbook", rmbook);
		/*
		System.out.println(rmbook.getId());
		System.out.println(rmbook.getBookName());
		System.out.println(rmbook.getBookAuthor());
		System.out.println(rmbook.getBookGenre());
		System.out.println(rmbook.getBookISBN());
		
		//System.out.println("On update page ");
        */
		Book oldbook = this.bookService.getBookById(rmbook.getBookId());
		
		/*
		System.out.println(oldbook.getBookName());
		System.out.println(oldbook.getBookAuthor());
		System.out.println(oldbook.getBookGenre());
		System.out.println(oldbook.getBookISBN());
		*/
		
		oldbook.setBookName(rmbook.getBookName());
		oldbook.setBookAuthor(rmbook.getBookAuthor());
		oldbook.setBookGenre(rmbook.getBookGenre());
		oldbook.setBookISBN(rmbook.getBookISBN());
		
		this.bookService.updateBookDetails(oldbook);
		
		
		return "redirect:/staffhome";
	}
	
	@RequestMapping("/adminhome")
    public String showAdminHome(Model model, RedirectAttributes redirectAttributes){
		
		System.out.println("Inside Staff Home");
		Users user = new Users();
		user.setUserType("Staff");
		redirectAttributes.addFlashAttribute("user", user);
        return "adminpage";
    }
	
	@RequestMapping(value = "/addStaff", method = RequestMethod.GET)
	public String addCustomer(Map model, RedirectAttributes redirectAttributes) {
		Users u = new Users();
		u.setUserType("Staff");
		redirectAttributes.addFlashAttribute("user", u);
		//model.put("user", u);
		
		return "redirect:/signup";
	}
	
 
}
