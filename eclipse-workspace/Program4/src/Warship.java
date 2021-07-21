class Warship
{
   private String _name;
   private String _country;
   private int _length; //feet
   private int _maneuverability;
   private int _displacement; //tons
   private int _crew;
   private int _speed; //knots
   private int _combatRating; 

   public Warship(String name, String country,
     int length, int maneuverability, int displacement,
     int crew, int speed, int combatRating )
   {
      _name = name;
      _country = country;
      _length = length;
      _maneuverability = maneuverability;
      _displacement = displacement;
      _crew = crew;
      _speed = speed;
      _combatRating = combatRating;
   }
   
   public String get_name()
   {
      return _name;
   }

   public String get_country()
   {
      return _country;
   }

   public int get_length()
   {
      return _length;
   }

   public int get_maneuverability()
   {
      return _maneuverability;
   }

   public int get_displacement()
   {
      return _displacement;
   }

   public int get_crew()
   {
      return _crew;
   }

   public int get_speed()
   {
      return _speed;
   }
 
   public int get_combatRating()
   {
      return _combatRating;
   }
 
   public String toString()
   {
      return "[" + _name + " : " + _country + "]\n" + 
         " (a) length: " + _length + " (b) maneuverability: " + _maneuverability + "\n" + 
         " (c) displacement: " + _displacement + " (d) crew: " + _crew + "\n" + 
         " (e) speed: " + _speed + " (f) combatRating: " + _combatRating + "\n";
   }
}
    
class WarshipArray
{
   private Warship[] _cards;

   public WarshipArray()
   {
      _cards = new Warship[]
         {   
         // name, country, length, maneuverability, displacement, crew, speed, combatRating
         new Warship("USS Missouri",           "USA",      887, 2,  45000, 1512, 35,  9),
         new Warship("USS George Washington",  "USA",     1092, 1, 102000, 6102, 30, 10),
         new Warship("USS Seawolf",            "USA",      353, 5,   9150,  116, 30,  7),
         
         new Warship("USS Cole",               "USA",      504, 3,   9033,  380, 32,  7),
         new Warship("Triton",                 "UK",        -1, 4,   6000,  100, 40,  7),
         new Warship("HMS Ark Royal",          "UK",       689, 1,  21000, 1395, 28,  7),
         
         new Warship("HMS Triumph",            "UK",       280, 5,   5208,  130, 32,  7),
         new Warship("HMS Ocean",              "UK",       667, 1,  21758, 1275, 19,  3),
         new Warship("HMS Vanguard",           "UK",       492, 4,  15900,  135, 25,  9),
         
         new Warship("USS Cushing",            "USA",      554, 4,   9300,  300, 33,  7),
         new Warship("Dalian",                 "China",    433, 3,   3670,  280, 32,  6),
         new Warship("Khaiber",                "Pakistan", 384, 3,   3250,  235, 30,  5),
         
         new Warship("Aconit",                 "France",   404, 4,   3600,  163, 25,  4),
         new Warship("USS Carl Vinson",        "USA",     1072, 1,  91487, 6062, 30, 10),
         new Warship("TK17 Typhoon",           "Russia",   563, 3,  33500,  150, 25,  9),
         
         new Warship("HS Elli",                "Greece",   427, 4,   3786,  140, 30,  5),
         new Warship("Quingdao",               "China",    486, 4,   5600,  230, 31,  6),
         new Warship("Oscar Class",            "Russia",   505, 5,  24000,  130, 32,  8),
         
         new Warship("KNM Skjold",             "Norway",   154, 6,    260,   -1, 60,  4),
         new Warship("Visby Class Corvette",   "Sweden",   236, 5,    60,    43, 35,  7),
         new Warship("DD{X} Zumwalt",          "USA",       -1, 4,  14000,   95, -1,  8),
         
         new Warship("HMS Belfast",            "UK",       613, 3,  13175,  750, 33,  6),
         new Warship("HDMS Thetis",            "Denmark",  370, 4,   3500,   60, 22,  4),
         new Warship("Kerkyra",                "Russia",   184, 6,    535,   27, 60,  2),
         
         new Warship("USS Cowpens",            "USA",      558, 4,   9590,  387, 31,  8),
         new Warship("SAM",                    "Sweden",    59, 2,     26,    0,  7,  0),
         new Warship("Sea Shadow",             "USA",      164, 3,    560,   24, 13,  1),
         
         new Warship("HMS Anzac",              "Australia",381, 4,   3600,  163, 28,  4),
         new Warship("MM Vittorio Venetto",    "Italy",    589, 1,   9500,  650, 32,  5),
         new Warship("USS Winston S Churchill","USA",      496, 4,   9435,  380, 32,  7)            
         };
   }

   public Warship[] getCards()
   {
      return _cards;
   }

}