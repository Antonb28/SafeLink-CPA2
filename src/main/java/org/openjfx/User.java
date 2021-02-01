package org.openjfx;
    public class User{
        public int CheckUser(String User, String Pass) {
            if (User.equals("james_feliciano@dlsu.edu.ph")) {
                if (Pass.equals("Preuxillion")) {
                    return 2;
                } else {
                    return 0;
                }
            } else if (User.equals("antonio_bautista@dlsu.edu.ph")) {
                if (Pass.equals("Prolts28")) {
                    return 3;
                } else {
                    return 0;
                }
            } else if (User.equals("jeremiah_jensen")) {
                if (Pass.equals("PreuxMcGarvin")) {
                    return 4;
                } else {
                    return 0;
                }
            }
            else if (User.equals("AntonB28")) {
                if (Pass.equals("Ton")) {
                    return 4;
                } else {
                    return 0;
                }
            }
            else if (User.equals("Admin")) {
                if (Pass.equals("Admin")) {
                    return 100;
                } else {
                    return 0;
                }
            }
            else {
                return 1;
            }
        }
    }





