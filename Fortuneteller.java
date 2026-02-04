import java.util.Scanner;
import java.util.Random;

public class FortuneTeller {
    
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("🔮✨ MYSTICAL FORTUNE TELLER ✨🔮");
        System.out.println("==================================\n");
        
        boolean running = true;
        
        while (running) {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║    What do you seek?        ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.println("1. 🔮 Crystal Ball Fortune");
            System.out.println("2. 🌟 Daily Horoscope");
            System.out.println("3. 🃏 Tarot Card Reading");
            System.out.println("4. 🎱 Magic 8-Ball");
            System.out.println("5. 🔢 Lucky Numbers");
            System.out.println("6. 💝 Love Compatibility");
            System.out.println("7. 🎯 Life Advice");
            System.out.println("8. 🌈 Color of the Day");
            System.out.println("9. 🚪 Exit");
            System.out.print("\nYour choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1: crystalBall(); break;
                case 2: dailyHoroscope(); break;
                case 3: tarotReading(); break;
                case 4: magic8Ball(); break;
                case 5: luckyNumbers(); break;
                case 6: loveCompatibility(); break;
                case 7: lifeAdvice(); break;
                case 8: colorOfDay(); break;
                case 9: 
                    System.out.println("\n✨ May fortune smile upon you! ✨");
                    running = false;
                    break;
                default: 
                    System.out.println("❌ Invalid choice!");
            }
        }
        
        scanner.close();
    }
    
    static void crystalBall() {
        String[] fortunes = {
            "🌟 A pleasant surprise is waiting for you!",
            "💰 Money will come to you from unexpected sources!",
            "❤️ Love is in the air - keep your heart open!",
            "🎓 Knowledge you gain today will help you tomorrow!",
            "🌈 Your creativity will lead to success!",
            "🏆 Hard work will pay off very soon!",
            "🎁 A gift from an old friend is coming your way!",
            "✈️ Adventure awaits - be ready to travel!",
            "📱 An important message will arrive soon!",
            "🌺 Your kindness will be rewarded!",
            "💡 A brilliant idea will strike you this week!",
            "🎨 Express yourself - your talent will shine!",
            "🔑 You will find what you've been searching for!",
            "☀️ Bright days are ahead of you!",
            "🤝 A new friendship will blossom!"
        };
        
        System.out.println("\n🔮 CRYSTAL BALL SPEAKS...");
        System.out.println("══════════════════════════════");
        animateThinking();
        System.out.println(fortunes[random.nextInt(fortunes.length)]);
        System.out.println("══════════════════════════════");
    }
    
    static void dailyHoroscope() {
        String[] signs = {"Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo",
                         "Libra", "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces"};
        
        System.out.println("\n🌟 SELECT YOUR ZODIAC SIGN:");
        for (int i = 0; i < signs.length; i++) {
            System.out.printf("%d. %s  ", (i+1), signs[i]);
            if ((i+1) % 3 == 0) System.out.println();
        }
        System.out.print("\nChoice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        if (choice >= 1 && choice <= 12) {
            String[] horoscopes = {
                "Today is perfect for taking bold initiatives!",
                "Focus on financial planning and long-term goals.",
                "Communication is key - express yourself clearly!",
                "Trust your intuition in important decisions.",
                "Your charisma will attract positive attention!",
                "Organization and detail will lead to success.",
                "Balance and harmony will bring you peace.",
                "Deep transformations are happening within you.",
                "Adventure and learning opportunities await!",
                "Your discipline will overcome all obstacles.",
                "Innovation and creativity are your strengths today.",
                "Let your compassion guide your actions."
            };
            
            String[] lucky = {"Red", "Green", "Yellow", "Blue", "Orange", "Purple",
                            "Pink", "Black", "White", "Gold", "Silver", "Turquoise"};
            
            int luckyNum = random.nextInt(100) + 1;
            
            System.out.println("\n✨ HOROSCOPE FOR " + signs[choice-1].toUpperCase() + " ✨");
            System.out.println("═════════════════════════════════════════");
            System.out.println("📜 " + horoscopes[choice-1]);
            System.out.println("🍀 Lucky Number: " + luckyNum);
            System.out.println("🎨 Lucky Color: " + lucky[choice-1]);
            System.out.println("⭐ Rating: " + getStars() + "/5 stars");
            System.out.println("═════════════════════════════════════════");
        } else {
            System.out.println("❌ Invalid zodiac sign!");
        }
    }
    
    static void tarotReading() {
        String[] cards = {
            "🌟 The Star - Hope, inspiration, and serenity await you!",
            "☀️ The Sun - Success, joy, and vitality are yours!",
            "🌙 The Moon - Trust your intuition and inner wisdom!",
            "⚡ The Tower - Sudden change brings new opportunities!",
            "❤️ The Lovers - Important relationship decisions ahead!",
            "🎡 The Wheel of Fortune - Life is about to take a turn!",
            "⚖️ Justice - Fairness and truth will prevail!",
            "👑 The Emperor - Take charge and lead with confidence!",
            "🦅 The Empress - Creativity and abundance surround you!",
            "🔮 The Magician - You have all tools needed to succeed!",
            "🌍 The World - Completion and achievement are near!",
            "💪 Strength - Inner power will overcome challenges!",
            "🎭 The Fool - New beginnings and adventures await!"
        };
        
        System.out.println("\n🃏 TAROT CARD READING");
        System.out.println("═════════════════════════════════════════");
        System.out.println("Focus on your question...");
        animateThinking();
        
        System.out.println("\nYour card is revealed:");
        System.out.println(cards[random.nextInt(cards.length)]);
        System.out.println("═════════════════════════════════════════");
    }
    
    static void magic8Ball() {
        String[] answers = {
            "🟢 Yes, definitely!",
            "🟢 It is certain!",
            "🟢 Without a doubt!",
            "🟢 You may rely on it!",
            "🟡 Reply hazy, try again!",
            "🟡 Ask again later!",
            "🟡 Better not tell you now!",
            "🟡 Cannot predict now!",
            "🔴 Don't count on it!",
            "🔴 My reply is no!",
            "🔴 Very doubtful!",
            "🔴 Outlook not so good!",
            "🟢 Signs point to yes!",
            "🟢 As I see it, yes!",
            "🟡 Concentrate and ask again!"
        };
        
        System.out.print("\n🎱 Ask the Magic 8-Ball a question: ");
        String question = scanner.nextLine();
        
        System.out.println("\n🎱 MAGIC 8-BALL SAYS...");
        animateShaking();
        System.out.println(answers[random.nextInt(answers.length)]);
    }
    
    static void luckyNumbers() {
        System.out.println("\n🔢 YOUR LUCKY NUMBERS TODAY");
        System.out.println("═════════════════════════════");
        
        System.out.print("🎰 Lottery Numbers: ");
        for (int i = 0; i < 6; i++) {
            System.out.print((random.nextInt(49) + 1) + " ");
        }
        
        System.out.print("\n🎲 Power Number: " + (random.nextInt(26) + 1));
        
        System.out.print("\n✨ Special Numbers: ");
        for (int i = 0; i < 3; i++) {
            System.out.print((random.nextInt(100) + 1) + " ");
        }
        
        System.out.println("\n═════════════════════════════");
    }
    
    static void loveCompatibility() {
        System.out.print("\n💝 Enter your name: ");
        String name1 = scanner.nextLine();
        
        System.out.print("💝 Enter partner's name: ");
        String name2 = scanner.nextLine();
        
        // Calculate "compatibility" based on name lengths and random
        int base = (name1.length() + name2.length()) * 5;
        int compatibility = (base + random.nextInt(40)) % 100;
        if (compatibility < 50) compatibility += 20;
        
        System.out.println("\n💕 LOVE COMPATIBILITY METER 💕");
        System.out.println("═════════════════════════════════");
        System.out.println(name1 + " ❤️ " + name2);
        
        // Progress bar
        System.out.print("Compatibility: [");
        for (int i = 0; i < 20; i++) {
            if (i < compatibility/5) System.out.print("❤");
            else System.out.print("♡");
        }
        System.out.println("] " + compatibility + "%");
        
        if (compatibility >= 80) {
            System.out.println("🌟 Perfect match! Soulmates!");
        } else if (compatibility >= 60) {
            System.out.println("💖 Great compatibility! Very promising!");
        } else if (compatibility >= 40) {
            System.out.println("💛 Good potential with effort!");
        } else {
            System.out.println("💙 Friendship might be better!");
        }
        System.out.println("═════════════════════════════════");
    }
    
    static void lifeAdvice() {
        String[] advice = {
            "🌱 Be patient - great things take time!",
            "💪 Believe in yourself - you're stronger than you think!",
            "🎯 Focus on your goals - success follows dedication!",
            "😊 Smile more - positivity attracts happiness!",
            "🤝 Help others - kindness always returns!",
            "📚 Never stop learning - knowledge is power!",
            "⏰ Time is precious - use it wisely!",
            "🌟 Dream big - you can achieve anything!",
            "💭 Think positive - your thoughts shape reality!",
            "🎨 Be creative - express your unique self!",
            "🌈 Embrace change - it leads to growth!",
            "❤️ Love yourself - you deserve it!",
            "🔥 Take risks - fortune favors the brave!",
            "🧘 Find balance - harmony brings peace!",
            "✨ Be grateful - appreciation attracts abundance!"
        };
        
        System.out.println("\n🎯 WISDOM FOR TODAY");
        System.out.println("═════════════════════════════");
        animateThinking();
        System.out.println(advice[random.nextInt(advice.length)]);
        System.out.println("═════════════════════════════");
    }
    
    static void colorOfDay() {
        String[] colors = {"Red", "Orange", "Yellow", "Green", "Blue", 
                          "Purple", "Pink", "Gold", "Silver", "White"};
        
        String[] meanings = {
            "Passion and energy - Be bold today!",
            "Creativity and enthusiasm - Express yourself!",
            "Happiness and optimism - Spread joy!",
            "Growth and harmony - Nurture relationships!",
            "Calm and trust - Stay peaceful!",
            "Wisdom and spirituality - Meditate!",
            "Love and compassion - Be kind!",
            "Success and prosperity - Seize opportunities!",
            "Clarity and reflection - Think deeply!",
            "Purity and new beginnings - Start fresh!"
        };
        
        int index = random.nextInt(colors.length);
        
        System.out.println("\n🌈 YOUR COLOR OF THE DAY");
        System.out.println("═════════════════════════════");
        System.out.println("🎨 Color: " + colors[index]);
        System.out.println("✨ Meaning: " + meanings[index]);
        System.out.println("💡 Wear or surround yourself with this color today!");
        System.out.println("═════════════════════════════");
    }
    
    // Animation methods
    static void animateThinking() {
        try {
            for (int i = 0; i < 3; i++) {
                System.out.print(".");
                Thread.sleep(500);
            }
            System.out.println();
        } catch (InterruptedException e) {
            System.out.println();
        }
    }
    
    static void animateShaking() {
        try {
            for (int i = 0; i < 3; i++) {
                System.out.print("Shaking");
                for (int j = 0; j < 3; j++) {
                    System.out.print(".");
                    Thread.sleep(300);
                }
                System.out.print("\r          \r");
            }
            System.out.println();
        } catch (InterruptedException e) {
            System.out.println();
        }
    }
    
    static String getStars() {
        int stars = random.nextInt(3) + 3; // 3-5 stars
        String result = "";
        for (int i = 0; i < stars; i++) {
            result += "⭐";
        }
        return result;
    }
}