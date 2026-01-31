package org.example.expense;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupMemberService {
    private final Grprep grpmrep;
    private final UserRep userrepo;
    private final GroupsRep groupsrep;

    public GroupMemberService( Grprep grpmrep, UserRep userrepo, GroupsRep groupsrep ) {
        this.grpmrep = grpmrep;
        this.userrepo = userrepo;
        this.groupsrep = groupsrep;
    }
public GroupMember add(long userId, long groupId) {
        User user= userrepo.findById(userId).orElse(null);
        Groups groups= groupsrep.findById(groupId).orElse(null);

        GroupMember groupmember = new GroupMember(user, groups);
    return grpmrep.save(groupmember);
}
    public List<GroupMember> getGroupMembers(long groupId) {
        Groups group = groupsrep.findById(groupId).orElseThrow();
        return grpmrep.findByGroup(group);
    }





}
