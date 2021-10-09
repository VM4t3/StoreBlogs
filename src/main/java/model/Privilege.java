package model;

public enum Privilege {
    ADMIN("admin"),
    MODERATOR("mod"),
    USER("usr"),
    OTHER("stb");


    private final String TYPE;

    Privilege(String privilege) {
        this.TYPE = privilege;
    }

    public static Privilege getPrivilegeByType(String type) {
        for (Privilege privilege : values()) {
            if(privilege.TYPE.equals(type)) {
                return privilege;
            }
        }
        return Privilege.OTHER;
    }


}