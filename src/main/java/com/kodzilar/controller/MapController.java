package com.kodzilar.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.kodzilar.service.MissionService;
import com.kodzilar.service.UserService;
import com.kodzilar.entity.History;
import com.kodzilar.entity.Mission;
import com.kodzilar.entity.Patient;

import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api/map")
public class MapController {

    @Value("${file.image.path}")
    private String imageDir;

    @Autowired
    private MissionService missionService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/mission", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Mission> getMission(@RequestBody Mission mission) {
        return missionService.getMissionByParkName( mission.getParkName() );
    }

    @RequestMapping(value="/answer", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public HttpStatus saveAnswer(@RequestBody History history){
        missionService.save(history);
        return HttpStatus.OK;
    }

    @RequestMapping(value="/history", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<History> getHistory(@RequestBody History history){
        return missionService.getHistoryById(history);
    }

    @RequestMapping(value="/date", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<History> getDate(@RequestBody History history){
        return missionService.getDateListById(history);
    }

    //http://stackoverflow.com/questions/42644337/upload-image-from-android-app-gallery-to-local-spring-server
    @RequestMapping(value="/upload")
    public void saveImage(@RequestParam("file") MultipartFile file) throws IOException{
        byte[] bytes = file.getBytes();
        Path path = Paths.get(imageDir + "/" + file.getOriginalFilename());
        Files.write(path, bytes);
    }

    //http://stackoverflow.com/questions/28381293/where-how-to-store-images-files-in-spring-mvc
    @RequestMapping(value="/images/{imageName}", method = RequestMethod.GET)
    @ResponseBody
    public byte[] getImage(@PathVariable String imageName) throws IOException {
        String preparingPath = imageDir + "/" + imageName + ".jpg";
        Path path = Paths.get(preparingPath);
        byte[] image = Files.readAllBytes( path );
        return image;
    }

    @RequestMapping(value="/patient", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<String> getPatientName(@RequestBody Patient patient){
        return missionService.getPatientListByCaretakerId(patient.getEmailCaretaker());
    }

    @RequestMapping(value="/historyCheck", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HttpStatus getCheckHistory(@RequestBody History history){
        history = missionService.getCheckHistoryByHistoryId(history.getHistoryId());
        history.setResult("Y");
        missionService.saveHistory(history);
        return HttpStatus.OK;
    }

    @RequestMapping(value="/historyCheckFalse", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HttpStatus getCheckHistoryFalse(@RequestBody History history){
        history = missionService.getCheckHistoryByHistoryId(history.getHistoryId());
        history.setResult("F");
        missionService.saveHistory(history);
        return HttpStatus.OK;
    }
}
