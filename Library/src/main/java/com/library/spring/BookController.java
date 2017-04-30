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
import com.library.spring.service.BookService;
import com.library.spring.service.SearchBooks;

@Controller
public class BookController {
	
	private BookService bookService;
	private SearchBooks searchBooks;
	
	@Autowired(required=true)
	@Qualifier(value="bookService")
	public void setBookService(BookService bs){
		this.bookService = bs;
	}
	
	@Autowired(required=true)
	@Qualifier(value="searchBooks")
	public void setSearchBooks(SearchBooks sb){
		this.searchBooks = sb;
	}
	
	@RequestMapping(value = "/books")
	public String custDash(Model model) {
		model.addAttribute("listBooks", this.bookService.listBooks());
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
        model.addAttribute("book", this.bookService.getBookById(id));
        return "BookDescription";
    }
	
	@RequestMapping("/borrow/{id}")
    public String borrowBook(@PathVariable("id") int id, Model model, @ModelAttribute("search") Search search){
		Book b = this.bookService.getBookById(id);
		b.setBookStatus(Status.Borrowed);
		this.bookService.updateBook(b);
		model.addAttribute("book", b);
		model.addAttribute("search", search);
	    return "bookSearch";
	    //return "redirect:/view/"+id;
    }
	
	@RequestMapping("/return/{id}")
    public String returnBook(@PathVariable("id") int id, Model model, HttpServletRequest request){
		Book b = this.bookService.getBookById(id);
		b.setBookStatus(Status.Available);
		this.bookService.updateBook(b);
		model.addAttribute("book", b);
		//return "redirect:/books";
		String referer = request.getHeader("Referer");
	    return "redirect:"+ referer;
    }
	
}
