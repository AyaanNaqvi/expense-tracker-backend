package org.example.expense;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class groupmembercontroller {
    private final GroupMemberService groupMemberService;
    public groupmembercontroller(GroupMemberService groupMemberService) {
        this.groupMemberService = groupMemberService;
    }
    @PostMapping("/{groupId}/users/{userId}")
    public GroupMember addGroupMember(     @PathVariable
                                               long groupId,
                                           @PathVariable
                                               long userId) {
        return groupMemberService.add(userId, groupId);

    }
    @GetMapping("/{groupId}/users")
    public List<GroupMember> getGroupMembers(@PathVariable long groupId) {
        return groupMemberService.getGroupMembers(groupId);
    }





}
