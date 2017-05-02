package com.library.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.library.spring.model.*;
import com.library.spring.service.LibraryService;
import com.library.spring.service.SearchBooks;

@Controller
public class LibraryController {
	
	private LibraryService libraryService;
	private SearchBooks searchBooks;
	private Users user;
	private Search search;
	
	@Autowired(required=true)
	@Qualifier(value="libraryService")
	public void setLibraryService(LibraryService bs){
		this.libraryService = bs;
	}
	
	@Autowired(required=true)
	@Qualifier(value="searchBooks")
	public void setSearchBooks(SearchBooks sb){
		this.searchBooks = sb;
	}
	
	@RequestMapping(value = "/books")
	public String custDash(@ModelAttribute("user") Users user, Model model) {
		//System.out.println(user.getUserName());
		if(user.getUserId()==null)
			user = this.user;
		else
			this.user = new Customer(user);
		model.addAttribute("listBooks", this.libraryService.listBooks(user));
		model.addAttribute("user", user);
		//this.user = new Customer(user);
		//model.addAttribute("listBooks");
		return "CustomerDash";
	}
	
	@RequestMapping(value = "/book/search/results")
	public String searchBooks(@ModelAttribute("search") Search search, Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("search", search);
		model.addAttribute("user", user);
		this.search=search;
		model.addAttribute("listBooks", this.searchBooks.search(search.getType(), search.getKey()));
		//model.addAttribute("listBooks");
		return "book";
	}
	
	@RequestMapping(value = "/book/search")
	public String listBooks(Model model) {
		model.addAttribute("search", new Search());
		model.addAttribute("user", user);
		//model.addAttribute("listBooks");
		return "bookSearch";
	}
	
	
	
	@RequestMapping("/view/{bookId}")
    public String viewBook(@PathVariable("bookId") int id, Model model){
        model.addAttribute("book", this.libraryService.getBookById(id));
        model.addAttribute("search", search);
        model.addAttribute("user", user);
        return "BookDescription";
    }
	
	@RequestMapping("/borrow/{bookId}")
    public String borrowBook(@PathVariable("bookId") int id, Model model){
		System.out.println(user.getUserId());
		Book b = this.libraryService.getBookById(id);
		this.libraryService.borrowBook(b,user);
		b.setBookStatus(Status.Borrowed);
		this.libraryService.updateBook(b);
		model.addAttribute("book", b);
		model.addAttribute("search", search);
		model.addAttribute("user", user);
	    //return "bookSearch";
		//return "redirect:/book/search/results";
	    return "redirect:/view/"+id;
    }
	
	@RequestMapping("/return/{bookId}")
    public String returnBook(@PathVariable("bookId") int id, Model model, HttpServletRequest request){
		Book b = this.libraryService.getBookById(id);
		BorrowedBooks bb = this.libraryService.getBorrowedBookById(id);
		this.libraryService.returnBook(bb);
		b.setBookStatus(Status.Available);
		this.libraryService.updateBook(b);
		model.addAttribute("book", b);
		model.addAttribute("search", search);
		model.addAttribute("user", user);
		//return "redirect:/books";
		String referer = request.getHeader("Referer");
	    return "redirect:"+ referer;
    }
	
	@RequestMapping("/extend/{bookId}")
    public String extendBook(@PathVariable("bookId") int id, Model model){
		System.out.println(user.getUserId());
		BorrowedBooks b = this.libraryService.getBorrowedBookById(id);
		this.libraryService.extendBook(b);
		//b.setBookStatus(Status.Borrowed);
		//this.libraryService.updateBook(b);
		model.addAttribute("book", b);
		model.addAttribute("search", search);
		model.addAttribute("user", user);
	    //return "bookSearch";
		//return "redirect:/book/search/results";
	    return "redirect:/view/"+id;
    }
	
}
