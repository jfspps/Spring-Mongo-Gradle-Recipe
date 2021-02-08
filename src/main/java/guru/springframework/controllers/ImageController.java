package guru.springframework.controllers;

import guru.springframework.services.ImageService;
import guru.springframework.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by jt on 7/3/17.
 */
@Controller
public class ImageController {

    private final ImageService imageService;
    private final RecipeService recipeService;

    public ImageController(ImageService imageService, RecipeService recipeService) {
        this.imageService = imageService;
        this.recipeService = recipeService;
    }

    @GetMapping("recipe/{id}/image")
    public String showUploadForm(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(id).block());

        return "recipe/imageuploadform";
    }

    // note here that MultipartFile (part of Servlet container) is blocking and so saving an image may appear a bit slow (the UI renders well before
    // the image the saved to the database instead of waiting for the image to save and then rendering)
    @PostMapping("recipe/{id}/image")
    public String handleImagePost(@PathVariable String id, @RequestParam("imagefile") MultipartFile file){

        imageService.saveImageFile(id, file).block();

        return "redirect:/recipe/" + id + "/show";
    }

//    @GetMapping("recipe/{id}/recipeimage")
//    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {
//        Mono<RecipeCommand> recipeCommand = recipeService.findCommandById(id);
//
//        if (recipeCommand.block().getImage() != null) {
//            byte[] byteArray = new byte[recipeCommand.block().getImage().length];
//            int i = 0;
//
//            for (Byte wrappedByte : recipeCommand.block().getImage()){
//                byteArray[i++] = wrappedByte; //auto unboxing
//            }
//
//            response.setContentType("image/jpeg");
//            InputStream is = new ByteArrayInputStream(byteArray);
//            IOUtils.copy(is, response.getOutputStream());
//        }
//    }
}
