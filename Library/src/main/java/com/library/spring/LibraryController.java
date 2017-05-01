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

import com.library.spring.model.Book;
import com.library.spring.model.Search;
import com.library.spring.model.Status;
import com.library.spring.service.LibraryService;
import com.library.spring.service.SearchBooks;

@Controller
public class LibraryController {
	
	private LibraryService libraryService;
	private SearchBooks searchBooks;
	
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
	public String custDash(Model model) {
		model.addAttribute("listBooks", this.libraryService.listBooks());
		//model.addAttribute("listBooks");
		return "CustomerDash";
	}
	
	@RequestMapping(value = "/book/search/results")
	public String searchBooks(@ModelAttribute("search") Search search, Model model) {
		model.addAttribute("book", new Book());
		
		model.addAttribute("listBooks", this.searchBooks.search(search.getType(), search.getKey()));
		model.addAttribute("search", search);
		//model.addAttribute("listBooks");
		return "book";
	}
	
	@RequestMapping(value = "/book/search")
	public String listBooks(Model model) {
		model.addAttribute("search", new Search());
		//model.addAttribute("listBooks");
		return "bookSearch";
	}
	
	/*//For add and update book both
	@RequestMapping(value= "/book/add", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("book") Book b){
		
		if(b.getId() == 0){
			//new book, add it
			this.bookService.addBook(b);
		}else{
			//existing book, call update
			this.bookService.updateBook(b);
		}
		
		return "redirect:/books";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") int id){
		
        this.bookService.removeBook(id);
        return "redirect:/books";
    }*/
 
    /*@RequestMapping("/edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        model.addAttribute("book", this.bookService.getBookById(id));
        model.addAttribute("listBooks", this.bookService.listBooks());
        return "book";
    }*/
	
	@RequestMapping("/view/{id}")
    public String viewBook(@PathVariable("id") int id, Model model){
        model.addAttribute("book", this.libraryService.getBookById(id));
        return "BookDescription";
    }
	
	@RequestMapping("/borrow/{id}")
    public String borrowBook(@PathVariable("id") int id, Model model, @ModelAttribute("search") Search search){
		Book b = this.libraryService.getBookById(id);
		b.setBookStatus(Status.Borrowed);
		this.libraryService.updateBook(b);
		model.addAttribute("book", b);
		model.addAttribute("search", search);
	    return "bookSearch";
	    //return "redirect:/view/"+id;
    }
	
	@RequestMapping("/return/{id}")
    public String returnBook(@PathVariable("id") int id, Model model, HttpServletRequest request){
		Book b = this.libraryService.getBookById(id);
		b.setBookStatus(Status.Available);
		this.libraryService.updateBook(b);
		model.addAttribute("book", b);
		//return "redirect:/books";
		String referer = request.getHeader("Referer");
	    return "redirect:"+ referer;
    }
	
}
