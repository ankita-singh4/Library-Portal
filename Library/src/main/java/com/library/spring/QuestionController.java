package com.library.spring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class QuestionController {
			
		private QuestionService questionService;
		
		@Autowired(required=true)
		@Qualifier(value="questionService")
		public void setQuestionService(QuestionService qs){
			this.questionService = qs;
		}
		
		@RequestMapping(value = "/questions", method = RequestMethod.GET)
		public String listquestions(Model model) {
			model.addAttribute("question", new Question());
			model.addAttribute("listQuestion", this.questionService.listquestions());
			return "question";
		}
		
		//adding a question
		@RequestMapping(value= "/question/add", method = RequestMethod.POST)
		public String addQuestion(@ModelAttribute("question") question q){
			
			if(q.getId() == 0){
				//new question, add it
				this.questionService.addquestion(q);
			}else{
				//existing question, call update
				this.questionService.updatequestion(q);
			}
			
			return "redirect:/questions";
			
		}
		
		@RequestMapping("/remove/{id}")
	    public String removequestion(@PathVariable("id") int id){
			
	        this.questionService.removequestion(id);
	        return "redirect:/questions";
	    }
	 
	    @RequestMapping("/edit/{id}")
	    public String editquestion(@PathVariable("id") int id, Model model){
	        model.addAttribute("question", this.questionService.getquestionById(id));
	        model.addAttribute("listquestions", this.questionService.listquestions());
	        return "question";
	    }
		
	}

}
