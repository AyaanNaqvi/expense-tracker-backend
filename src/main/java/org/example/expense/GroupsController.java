package org.example.expense;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/groups")
public class GroupsController {

    private final GroupService groupsService;
    private final Debtservice debtservice;


    public GroupsController(GroupService groupsService,
                            Debtservice debtservice) {
        this.groupsService = groupsService;
        this.debtservice = debtservice;
    }

    @PostMapping
    public Groups creategroups(@RequestBody Groups groups) {
        return groupsService.addgroups(groups);
    }

    @DeleteMapping("/{groupId}")
    public void deletegroups(@PathVariable long groupId) {

        groupsService.deleteGroups(groupId);





    }

    @GetMapping
    public List<Groups> getgroups() {
        return groupsService.getgroups();
    }



}
