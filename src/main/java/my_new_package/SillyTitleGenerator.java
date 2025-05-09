package my_new_package;
import java.util.Random;

/////////////////////////////
// SILLY TITLE GENERATOR ////
/////////////////////////////



public class SillyTitleGenerator {

    static String[] sillyPrefixes = {
            "Most Flimsical",
            "Admiral Bumblepants",
            "Sir Wobblepot",
            "Baron Von Snickerdoodle",
            "Lady Fuzzlewhump",
            "Captain Crinkleboot",
            "Reverend Jibberjabber",
            "Doctor Muddlehead",
            "Professor Wigglytoes",
            "Archduke Flapjack",
            "Grandmaster Puddleduck",
            "Supreme Count Bafflestuff",
            "His Noodleyness",
            "The Right Honorable Snortlepuff",
            "Duchess Sillywig",
            "Wizard McFancypants",
            "The Esteemed Guffawlord",
            "Knight of the Dingleberries",
            "Official Whimsybringer",
            "Marshal Tickletuft",
            "Lord Bamboozleton",
            "Countess of Blunderburg",
            "Viceroy Jollymuffin",
            "Grand Poohbah of the Lillies",
            "Sovereign Gigglemonger",
            "Master of the Puddle Realm",
            "Empress Bumblebee",
            "Chancellor Grouchlord",
            "Abbess of Flimflam",
            "Royal Twiddlethumb",
            "Commander of Silliness",
            "Pompous Doodlewhisk",
            "Prestigious Wobblemeister",
            "Yonder High Wibblewob",
            "Majestic Splendiferousness",
            "Perturbator Extraordinaire",
            "The Bouncing Sage",
            "Keeper of the Flapdoodle",
            "Cardinal Puffypaws",
            "Sheriff Wigglenose",
            "Serene Splotchmaster",
            "Sovereign Squigglebutt",
            "Inspector Bumblebottom",
            "His Absurdness",
            "Twinklemaster General",
            "Mayor of Mumbleton",
            "Patriarch of Tittertown",
            "Jester Supreme",
            "Champion of the Blitherfields",
            "Magnificent Grumblecake"
    };
    static String[] sillySuffixes = {
            "the Grandiferous",
            "the Befuddled",
            "of Wobblewick",
            "the Snickering",
            "the Tumultuous",
            "the Sparklefooted",
            "from Flapjack Falls",
            "the Bamboozled",
            "of the Twiddly Isles",
            "the Ever-Jubilant",
            "the Flapdoodler",
            "the Waggly-Fingered",
            "the Giddy-Goober",
            "of Bumblewharf",
            "the Perplexinator",
            "the Exasperating",
            "of Crinkletown",
            "the Undefinable",
            "the Drizzlemancer",
            "of the Noisy Tree",
            "the Howling Dervish",
            "whose title we forgot",
            "the Beflustered",
            "the Jigglypuffed",
            "of the Mirthful Marches",
            "the Curious Cabbage",
            "the Meandering",
            "from Tittertop Heights",
            "the Flibberflabber",
            "the Grinworthy",
            "the Ever-Bouncy",
            "the Quizzical",
            "from the Guffaw Groves",
            "the Bewigged",
            "of the Wobbleworks",
            "the Ineffably Grand",
            "from Blooperville",
            "the Bubblebard",
            "the Squeaky-Crowned",
            "the Dazzlepuff",
            "of the Fiddlefen",
            "the Staggeringly Peculiar",
            "the Frabjous",
            "the Chuckletuft",
            "of Whifflewood",
            "the Impressionable",
            "the Moozled",
            "the Bumbleborn",
            "of the Flabby Hills",
            "the Grumpy"
    };

    private static final Random random = new Random();

    public static String generateTitle(String username) {
        String prefix = sillyPrefixes[random.nextInt(sillyPrefixes.length)];
        String suffix = sillySuffixes[random.nextInt(sillySuffixes.length)];
        return prefix + ", " + username + ", " + suffix;
    }
}