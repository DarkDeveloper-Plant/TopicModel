package ir.plant.darkdev.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @RequestMapping("/topic")
    public List<TopicModel> getTopics() {
        return topicService.getAll();
    }

    @RequestMapping("/topic/{id}")
    public TopicModel getTopic(@PathVariable String id){
        return topicService.getOne(id);
    }

    @RequestMapping(value = "/topic", method = RequestMethod.POST)
    public List<TopicModel> addTopic(@RequestBody TopicModel newTopic){
        topicService.addOne(newTopic);
        return getTopics();
    }

    @RequestMapping(value = "/topic/{id}", method = RequestMethod.DELETE)
    public List<TopicModel> removeTopic(@PathVariable String id){
        topicService.removeOne(id);
        return getTopics();
    }

    @RequestMapping(value = "/topic/{id}", method = RequestMethod.PUT)
    public List<TopicModel> updateTopic(@PathVariable String id, @RequestBody TopicModel newTopic){
        topicService.updateTopic(id, newTopic);
        return getTopics();
    }

}
