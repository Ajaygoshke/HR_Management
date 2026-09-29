package com.Hr_Management.Security;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.Hr_Management.Enum.Permissions;
import com.Hr_Management.Enum.Role;

public class RoleBasedPermissions {

	
	public static Map<Role,Set<Permissions>>getRoleBasedPermissions(){
		
		Map<Role,Set<Permissions>> permission=new HashMap<>();
		permission.put(Role.ADMIN, new HashSet<Permissions>(Arrays.asList(
				Permissions.APPOVE_LEAVE,Permissions.CREATE_EMPLOYEE,Permissions.DELETE_EMPLOYEE,Permissions.UPDATE_EMPLOYEE,Permissions.VIEW_EMPLOYEE,
				Permissions.VIEW_ANALYTICES,Permissions.VIEW_PAYROLE,Permissions.VIEW_HOLIDAYS,Permissions.RUN_PAYROLE) ));
		
		permission.put(Role.HR, new HashSet<Permissions>(Arrays.asList(
				Permissions.APPLY_LEAVE,
				Permissions.APPLY_WFH,
				Permissions.APPOVE_LEAVE,
				Permissions.APPOVE_WFH,
				Permissions.CREATE_EMPLOYEE,
				Permissions.UPDATE_EMPLOYEE,
				Permissions.VIEW_EMPLOYEE,
				Permissions.VIEW_HOLIDAYS,
				Permissions.VIEW_PAYROLE)));
		
		permission.put(Role.EMPLOYEE,new HashSet<Permissions>(Arrays.asList(
				Permissions.APPLY_LEAVE,
				Permissions.APPLY_WFH,
				Permissions.VIEW_EMPLOYEE,
				Permissions.VIEW_HOLIDAYS,
				Permissions.VIEW_PAYROLE,
				Permissions.VIEW_ATTENDENCE
				)));
		return permission;
		
	}
}
