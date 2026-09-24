package com.example.data.repository

import com.example.data.model.KrishnaQuizQuestion
import com.example.data.model.KrishnaStory

object KrishnaStoriesRepository {

    val stories: List<KrishnaStory> = listOf(
        KrishnaStory(
            id = "ks_birth_mathura",
            chapter = 1,
            title = "The Divine Appearance in Mathura",
            subtitle = "A stormy midnight, opening prison gates, and the gentle Yamuna",
            moralLesson = "When darkness seems overwhelming, divine hope and courage always emerge.",
            quote = "\"Fear not, for truth and righteousness can never be imprisoned by injustice.\"",
            emoji = "🌌",
            accentColorHex = 0xFF3F51B5,
            readingTimeMinutes = 4,
            summary = "On the dark, stormy night of Ashtami, Lord Krishna is born in the dungeons of tyrant King Kamsa in Mathura. In miraculous silence, heavy iron chains fall away and Vasudeva carries baby Krishna safely across river Yamuna to Gokul.",
            fullStoryParagraphs = listOf(
                "Long ago in the ancient city of Mathura, the cruel King Kamsa ruled with an iron fist. Because a divine prophecy warned him that the eighth child of his sister Devaki would bring an end to his tyrannical reign, he imprisoned Devaki and her husband Vasudeva in a fortress guarded by fierce soldiers.",
                "On the midnight of the eighth day (Ashtami) of the dark fortnight of Bhadrapada month, a miraculous glow illuminated the dim stone cell. Lord Krishna appeared in his four-armed divine form before transforming into an adorable, dark-complexioned newborn with lotus eyes.",
                "A gentle celestial voice instructed Vasudeva: 'Take this divine child without fear to Gokul across the Yamuna River, and exchange him with the newborn daughter of chieftain Nanda and mother Yashoda.'",
                "Suddenly, the heavy iron padlocks fell open, the thick wooden prison gates swung outward, and all the guards fell into a deep, magical slumber. Vasudeva placed baby Krishna gently inside a wicker basket on his head and stepped into the raging midnight storm.",
                "As the rain poured, the great celestial serpent Adishesha unfurled his many hoods to protect the child like an umbrella. When Vasudeva stepped into the swollen, turbulent waters of River Yamuna, the river parted respectfully to let them pass. Vasudeva reached Gokul safely, placing baby Krishna in Yashoda's arms while she slept, completing the miraculous journey."
            ),
            audioTrackName = "Midnight Miracle • Rain & Divine Lullaby",
            relatedYouTubeVideoId = "w1y1gA_4XHQ",
            tags = listOf("Divine Birth", "Mathura", "Yamuna", "Vasudeva"),
            quiz = listOf(
                KrishnaQuizQuestion(
                    question = "Where was Lord Krishna born?",
                    options = listOf("In a palace garden", "In a prison cell in Mathura", "In Vrindavan forest", "In Ayodhya"),
                    correctOptionIndex = 1,
                    explanation = "Krishna was born in the fortress prison of Mathura where Kamsa held Devaki and Vasudeva."
                ),
                KrishnaQuizQuestion(
                    question = "Who shielded baby Krishna from the rain with his hoods?",
                    options = listOf("Garuda the eagle", "Adishesha the celestial serpent", "An elephant", "Nandi the bull"),
                    correctOptionIndex = 1,
                    explanation = "The celestial serpent Adishesha spread his hoods like an umbrella to shield Krishna from the stormy rain."
                ),
                KrishnaQuizQuestion(
                    question = "To whose home in Gokul did Vasudeva take baby Krishna?",
                    options = listOf("King Janaka", "Nanda and Yashoda", "Sage Sandipani", "Sudama"),
                    correctOptionIndex = 1,
                    explanation = "Vasudeva carried baby Krishna safely to the loving home of Nanda and Yashoda in Gokul."
                )
            )
        ),

        KrishnaStory(
            id = "ks_makhan_chor",
            chapter = 2,
            title = "Makhan Chor: The Great Butter Mystery",
            subtitle = "Playful giggles, hanging clay pots, and sharing with monkey friends",
            moralLesson = "Pure joy lies in selfless sharing and bringing smiles to others.",
            quote = "\"Butter made with love tastes sweetest when shared with friends.\"",
            emoji = "🧈",
            accentColorHex = 0xFFFFB300,
            readingTimeMinutes = 3,
            summary = "Little Krishna's irresistible love for freshly churned butter leads to playful escapades across Gokul. With the help of his cowherd friends and eager monkeys, no hanging butter pot is too high!",
            fullStoryParagraphs = listOf(
                "As Little Krishna grew into a cheerful toddler with anklets that chimed like bells, all of Gokul fell in love with his charming smile. Yet, the gopis (milkmaids) faced a delightful mystery every morning: their freshly churned earthen pots of butter kept disappearing!",
                "Mother Yashoda and the neighborhood gopis decided to hang their precious pots high up from the wooden ceiling beams, well out of reach of any toddler's hands. But Little Krishna was clever beyond imagination.",
                "Gathering his closest cowherd friends—Subala, Sridama, and Mansukh—Krishna hatched a mischievous plan. The boys stood upon one another's shoulders to form a human pyramid, with little Krishna climbing right to the top!",
                "With a small pebble, he would tap a tiny hole in the bottom of the pot. As the golden, aromatic butter dripped down, the boys caught it with open mouths and gave big handfuls to the neighborhood monkeys waiting on the windowsill!",
                "When Yashoda caught Krishna with white butter smeared across his cheeks, he innocently opened his big doe eyes and said, 'Mother, my hands were cold, so I was only warming them inside the pot!' Yashoda could not stay angry and embraced him with overflowing love."
            ),
            audioTrackName = "Gokul Churning Song • Chimes & Flute",
            relatedYouTubeVideoId = "w1y1gA_4XHQ",
            tags = listOf("Makhan Chor", "Butter", "Yashoda", "Gokul"),
            quiz = listOf(
                KrishnaQuizQuestion(
                    question = "Why was Little Krishna called 'Makhan Chor'?",
                    options = listOf("He stole sweets", "He loved to playfully steal butter", "He collected gold", "He chased cows"),
                    correctOptionIndex = 1,
                    explanation = "Makhan means butter and Chor means thief; he was affectionately known for his playful butter escapades."
                ),
                KrishnaQuizQuestion(
                    question = "How did Krishna reach the high hanging pots?",
                    options = listOf("He used a tall ladder", "The boys formed a human pyramid", "He flew up", "He threw a rope"),
                    correctOptionIndex = 1,
                    explanation = "His cowherd friends stood on each other's shoulders to help Krishna reach the hanging pots."
                ),
                KrishnaQuizQuestion(
                    question = "Who did Krishna share the butter with besides his friends?",
                    options = listOf("Pet parrots", "Friendly monkeys", "Horses", "Elephants"),
                    correctOptionIndex = 1,
                    explanation = "Krishna gladly shared the dripped butter with the playful monkeys of Gokul."
                )
            )
        ),

        KrishnaStory(
            id = "ks_yashoda_universe",
            chapter = 3,
            title = "The Universe in Little Krishna's Mouth",
            subtitle = "A handful of clay and the boundless cosmic vision to Mother Yashoda",
            moralLesson = "The supreme truth exists everywhere, even in the smallest speck of dust.",
            quote = "\"Within the heart of the innocent child resides the entire universe.\"",
            emoji = "🌌",
            accentColorHex = 0xFF7E57C2,
            readingTimeMinutes = 3,
            summary = "When elder brother Balarama complains that little Krishna ate dirt, Mother Yashoda lovingly scolds him and demands he open his mouth. Peering inside, she sees the entire cosmos, galaxies, oceans, and all living beings.",
            fullStoryParagraphs = listOf(
                "One afternoon while playing in the courtyards of Gokul, elder brother Balarama and the other playmates ran to Mother Yashoda shouting, 'Mother, Kanha has eaten clay from the river bank!'",
                "Worried for her little boy's health, Yashoda took a small stick and hurried outside. Catching Krishna by the hand, she asked sternly, 'Why have you eaten dirt, you naughty boy? See your brother and friends are telling the truth!'",
                "Krishna blinked innocently and answered, 'Mother, they are telling tales because they lost the game. If you don't believe me, look inside my mouth yourself!'",
                "Yashoda knelt down and said, 'Open wide!' Krishna opened his tiny mouth. As Yashoda looked inside, her breath caught in awe and astonishment.",
                "Inside the child's little mouth, she did not see a grain of clay. Instead, she beheld the entire cosmic expanse—the spinning sun, moon, and stars, vast oceans, majestic mountain ranges, galaxies, flowing winds, time itself, and within it all, Gokul, her house, and herself looking into Krishna's mouth!",
                "Realizing she was gazing upon the supreme source of all existence, Yashoda bowed in profound reverence. In an instant, Krishna restored the sweet veil of motherly love, and Yashoda picked him up in her arms, kissing his forehead with pure maternal joy."
            ),
            audioTrackName = "Cosmic Vision • Celestial Echoes & Tambura",
            relatedYouTubeVideoId = "V_4U_gPkW2c",
            tags = listOf("Mother Yashoda", "Universe", "Balarama", "Cosmos"),
            quiz = listOf(
                KrishnaQuizQuestion(
                    question = "Who reported to Mother Yashoda that Krishna ate dirt?",
                    options = listOf("Nanda Baba", "Balarama and the playmates", "A gopi", "The king"),
                    correctOptionIndex = 1,
                    explanation = "Elder brother Balarama and the cowherd friends came running to tell Yashoda."
                ),
                KrishnaQuizQuestion(
                    question = "What did Mother Yashoda see inside Krishna's mouth?",
                    options = listOf("A shiny jewel", "Laddus and butter", "The entire cosmos and galaxies", "Only clay"),
                    correctOptionIndex = 2,
                    explanation = "Yashoda saw the vast universe, sun, moon, stars, oceans, and all living beings inside his mouth."
                ),
                KrishnaQuizQuestion(
                    question = "What feeling overwhelmed Mother Yashoda after the cosmic vision?",
                    options = listOf("Deep anger", "Profound awe, reverence, and maternal love", "Fear", "Sadness"),
                    correctOptionIndex = 1,
                    explanation = "She realized his supreme divinity and embraced him with unbounded love."
                )
            )
        ),

        KrishnaStory(
            id = "ks_kaliya_narthanam",
            chapter = 4,
            title = "Taming the Kaliya Serpent (Kaliya Narthanam)",
            subtitle = "Purifying Yamuna River and dancing upon the multi-hooded snake",
            moralLesson = "True strength overcomes venom and pride with grace, compassion, and discipline.",
            quote = "\"Arrogance poisons one's own environment; humility purifies all waters.\"",
            emoji = "🐍",
            accentColorHex = 0xFF00897B,
            readingTimeMinutes = 4,
            summary = "The venomous serpent Kaliya pollutes the holy waters of River Yamuna, endangering birds, cows, and villagers. Young Krishna boldly dives in, leaps atop Kaliya's many hoods, and dances the legendary Kaliya Narthanam to protect Gokul.",
            fullStoryParagraphs = listOf(
                "In a deep pool of River Yamuna, a giant, multi-headed serpent named Kaliya took residence. His toxic venom was so potent that the river waters boiled with poison; any bird flying over the pool plummeted lifeless, and nearby trees turned brittle and gray.",
                "One sunny afternoon, Krishna and his cowherd friends were playing with a ball near the riverbank. When the ball accidentally fell into Kaliya's swirling black pool, Krishna climbed a tall Kadamba tree and leaped straight into the water!",
                "Enraged by the intrusion, Kaliya rose from the depths with his hundred hoods hissing fire and venom, coiling his massive scaly body around Krishna. The cowherds and villagers on the bank watched in petrified terror.",
                "With ease, Krishna expanded his strength, broke free from the coils, and sprang onto the crest of Kaliya's central hood. As celestial musicians struck up heavenly rhythms in the sky, Krishna began dancing gracefully—the historic Kaliya Narthanam!",
                "Whenever Kaliya raised a hood in anger, Krishna stepped upon it with rhythmic precision, crushing the serpent's poisonous pride. Soon, Kaliya's heads bowed low, exhausted and defeated.",
                "The serpent's wives (Nagapatnis) surfaced with folded hands, pleading for Krishna's mercy. Filled with compassion, Krishna spared Kaliya's life on one condition: 'Depart from Yamuna and live peacefully in the island of Ramanaka. Because my footprints now mark your hoods, Garuda will never harm you.' River Yamuna returned to its pristine, sweet crystal waters."
            ),
            audioTrackName = "Kaliya Narthanam • Rhythmic Mridangam & Flute",
            relatedYouTubeVideoId = "w1y1gA_4XHQ",
            tags = listOf("Kaliya", "Yamuna", "Kaliya Narthanam", "Dance"),
            quiz = listOf(
                KrishnaQuizQuestion(
                    question = "Why was the pool of River Yamuna dangerous?",
                    options = listOf("Strong whirlpools", "The poisonous serpent Kaliya lived there", "Sharks lived there", "Too much salt"),
                    correctOptionIndex = 1,
                    explanation = "The multi-headed serpent Kaliya spewed lethal venom that polluted the river pool."
                ),
                KrishnaQuizQuestion(
                    question = "What did Krishna do atop Kaliya's hoods?",
                    options = listOf("He danced the Kaliya Narthanam", "He tied a rope", "He played chess", "He sang a lullaby"),
                    correctOptionIndex = 0,
                    explanation = "Krishna danced gracefully upon the serpent's hoods, subduing its pride."
                ),
                KrishnaQuizQuestion(
                    question = "Where was Kaliya instructed to live peacefully?",
                    options = listOf("Mathura palace", "Ramanaka island in the ocean", "Gokul pond", "Mount Meru"),
                    correctOptionIndex = 1,
                    explanation = "Krishna commanded Kaliya to leave Yamuna and reside in Ramanaka island."
                )
            )
        ),

        KrishnaStory(
            id = "ks_govardhan_hill",
            chapter = 5,
            title = "Lifting of Govardhan Hill: The Divine Umbrella",
            subtitle = "Seven days, seven nights, and the shelter of Gokul on a little finger",
            moralLesson = "True protection comes from selfless devotion and unity, conquering false ego.",
            quote = "\"Nature and cattle give us life; honoring our sacred earth protects us all.\"",
            emoji = "🏔️",
            accentColorHex = 0xFF43A047,
            readingTimeMinutes = 4,
            summary = "When villagers prepare a massive sacrifice for rain god Indra, young Krishna convinces them to instead honor Govardhan Hill and their sacred cattle. In anger, Indra sends torrential deluges, but Krishna lifts the entire mountain on his little finger for seven days to shelter Gokul.",
            fullStoryParagraphs = listOf(
                "Every autumn, Nanda Baba and the elders of Gokul gathered bountiful harvests to perform the traditional Indra Yajna to appease the rain god Indra. Young Krishna approached his father with gentle wisdom.",
                "'Father,' Krishna argued, 'King Indra does not command the rain by himself; nature acts by its divine duty. It is Govardhan Hill that feeds our cows with lush green grass, yields fresh mountain streams, and provides timber. We should worship Govardhan Hill and our gentle cows!'",
                "Convinced by Krishna's words, the villagers offered the grand feast to Govardhan Hill instead. Up in the heavens, Lord Indra felt slighted and flew into an uncontrollable rage.",
                "Determined to punish Gokul, Indra unleashed the furious Samvartaka clouds of destruction. Torrential downpours, ferocious gale winds, and blinding thunderbolts lashed across Gokul, flooding pastures and terrifying cattle and villagers alike.",
                "Seeing his people shivering in fear, young Krishna smiled warmly. Walking to Govardhan Hill, he effortlessly lifted the colossal mountain onto the little finger of his left hand, holding it high like a giant umbrella!",
                "'Come under the shelter of Govardhan, all of you!' Krishna called out. For seven continuous days and seven nights, all the villagers, children, cows, and animals stood safely together under the mountain shelter while Krishna stood serene and smiling.",
                "Exhausted and thoroughly humbled, Indra realized that the boy was the Lord of the Universe. Indra dispersed the clouds, bowed at Krishna's lotus feet in deep repentance, and crowned him 'Govinda'—the loving protector of cows and devotees."
            ),
            audioTrackName = "Govardhan Shelter • Peaceful Mountain Raga",
            relatedYouTubeVideoId = "V_4U_gPkW2c",
            tags = listOf("Govardhan", "Indra", "Govinda", "Mountain"),
            quiz = listOf(
                KrishnaQuizQuestion(
                    question = "On which finger did Krishna lift Govardhan Hill?",
                    options = listOf("Right thumb", "Little finger of his left hand", "Right index finger", "Both hands"),
                    correctOptionIndex = 1,
                    explanation = "Krishna lifted the entire mountain effortlessly on the little finger of his left hand."
                ),
                KrishnaQuizQuestion(
                    question = "For how many days did Krishna hold up Govardhan Hill?",
                    options = listOf("One day", "Three days", "Seven days and seven nights", "A full month"),
                    correctOptionIndex = 2,
                    explanation = "Krishna held up the mountain umbrella continuously for seven days and seven nights."
                ),
                KrishnaQuizQuestion(
                    question = "What sacred title did Indra bestow upon Krishna after repenting?",
                    options = listOf("Govinda (Protector of Cows & devotees)", "Raja", "Senapati", "Yoddha"),
                    correctOptionIndex = 0,
                    explanation = "Indra honored Krishna with the divine title 'Govinda'."
                )
            )
        ),

        KrishnaStory(
            id = "ks_venu_gaanam",
            chapter = 6,
            title = "The Enchanting Flute of Vrindavan (Venu Gaanam)",
            subtitle = "Melodies of universal harmony that made peacocks dance and rivers pause",
            moralLesson = "Live like a hollow bamboo flute—empty of ego, so divine melody can flow through.",
            quote = "\"When the heart is pure and empty of pride, every word becomes music.\"",
            emoji = "🪈",
            accentColorHex = 0xFF00ACC1,
            readingTimeMinutes = 3,
            summary = "Krishna's simple bamboo flute (Venu) produces music so sublime that all of nature gathers in spellbound peace. Deers graze without fear, cows give sweet milk, and peacocks unfurl iridescent feathers in joyful celebration.",
            fullStoryParagraphs = listOf(
                "In the fragrant groves of Vrindavan, where Kadamba and Parijata blossoms filled the breeze with sweetness, Krishna held a simple piece of hollow bamboo known as the Venu.",
                "Though plain in appearance, when placed to Krishna's lips, the flute resonated with melodies of divine love that transcended the material world. The sound carried across meadows, hills, and riverbanks.",
                "Hearing the celestial notes of Venu Gaanam, the calves stopped suckling milk and listened with ears perked upright. Wild deer came close and rested their heads against the cowherds' knees without the slightest trace of fear.",
                "Peacocks began calling in chorus, unfurling their brilliant sapphire and emerald feathers to dance in ecstatic circles around Krishna. Even the gentle Yamuna River seemed to slow its current to linger by the bank and catch the melody.",
                "The cowherds once asked the flute, 'What austerity did you perform to taste the nectar of Krishna's lips all day?' The flute whispered in reply, 'I am only hollow inside. Having emptied myself of ego and desire, the Lord breathes his own music through me.' This timeless lesson reminds us that humility transforms every life into a divine instrument."
            ),
            audioTrackName = "Vrindavan Sunset • Bamboo Flute & Sitar",
            relatedYouTubeVideoId = "k9HqM-fX_d8",
            tags = listOf("Flute", "Venu Gaanam", "Music", "Vrindavan"),
            quiz = listOf(
                KrishnaQuizQuestion(
                    question = "What is Krishna's sacred bamboo flute called?",
                    options = listOf("Venu or Murali", "Veena", "Dholak", "Shankha"),
                    correctOptionIndex = 0,
                    explanation = "Krishna's sacred bamboo flute is known as Venu, Murali, or Bansuri."
                ),
                KrishnaQuizQuestion(
                    question = "How did peacocks react when Krishna played the flute?",
                    options = listOf("They flew far away", "They unfurled their feathers and danced", "They hid in trees", "They slept"),
                    correctOptionIndex = 1,
                    explanation = "The peacocks joyously unfurled their plumage and danced in celebration."
                ),
                KrishnaQuizQuestion(
                    question = "What was the flute's secret to producing such divine music?",
                    options = listOf("Made of solid gold", "Being hollow inside (free of ego)", "Encrusted with diamonds", "Made by kings"),
                    correctOptionIndex = 1,
                    explanation = "The flute explained that being hollow and free of ego allowed the Lord's music to flow effortlessly."
                )
            )
        ),

        KrishnaStory(
            id = "ks_sudama_friendship",
            chapter = 7,
            title = "Sudama's Poha: The True Treasure of Friendship",
            subtitle = "A humble handful of beaten rice, palace tears, and eternal devotion",
            moralLesson = "Friendship and love are measured by sincerity of the heart, never by wealth.",
            quote = "\"A single grain offered with pure love outweighs all the jewels of the world.\"",
            emoji = "🤝",
            accentColorHex = 0xFFD81B60,
            readingTimeMinutes = 4,
            summary = "Poverty-stricken Sudama visits his childhood Gurukul classmate, King Krishna of Dwarka. Ashamed of his gift of coarse beaten rice (poha), Sudama hides it, but Krishna ecstatically discovers it, honoring pure friendship with boundless blessings.",
            fullStoryParagraphs = listOf(
                "During their boyhood at Sage Sandipani's Gurukul, Krishna and poor Brahmin boy Sudama were inseparable friends who gathered firewood, studied scriptures, and shared every meal together. Years later, Krishna became the magnificent King of Dwarka, while Sudama lived in extreme poverty with his family.",
                "Seeing her children sleeping hungry, Sudama's pious wife suggested, 'Your Gurukul classmate is Krishna, the King of Dwarka who loves devotees. Please visit him—not to beg, but simply to see your dear friend.'",
                "Sudama agreed, but felt sorrowful that he had no gift to bring. His wife borrowed a handful of flattened beaten rice (poha) from neighbors and tied it into a tattered cotton cloth.",
                "When Sudama reached the opulent golden gates of Dwarka palace, clad in dusty, frayed robes, the royal guards were hesitant. But the moment Krishna heard Sudama's name, he rushed barefoot out of his palace, throwing his arms around his old friend in tears of pure joy!",
                "Krishna seated Sudama on his own royal golden throne, washed his weary feet with scented waters, and served him royal delicacies. Sudama felt ashamed of his humble packet of poha and tried to conceal it behind his back.",
                "Noticing this, Krishna playfully snatched the little cloth bundle, exclaiming, 'Brother! What delicious treat has your wife sent for me?' Krishna took a joyful mouthful of the plain poha with supreme delight, tasting the unconditional love within it.",
                "When Sudama returned to his village without having asked for anything, he found his thatched hut transformed into a magnificent stone mansion filled with abundance, while his heart remained eternally devoted to his divine friend."
            ),
            audioTrackName = "Song of Friendship • Melodic Sitar & Veena",
            relatedYouTubeVideoId = "y0X7L_2V5jA",
            tags = listOf("Sudama", "Dwarka", "Friendship", "Poha"),
            quiz = listOf(
                KrishnaQuizQuestion(
                    question = "Where did Krishna and Sudama first become friends?",
                    options = listOf("At Mathura school", "At Sage Sandipani's Gurukul", "At Dwarka", "At Gokul"),
                    correctOptionIndex = 1,
                    explanation = "They studied together under Sage Sandipani at his forest Gurukul."
                ),
                KrishnaQuizQuestion(
                    question = "What humble gift did Sudama bring for Krishna?",
                    options = listOf("Golden coins", "A handful of beaten rice (poha)", "Sweet mangoes", "Silken garments"),
                    correctOptionIndex = 1,
                    explanation = "Sudama brought a small bundle of beaten rice tied in a torn cloth."
                ),
                KrishnaQuizQuestion(
                    question = "How did Krishna receive poor Sudama at his royal palace?",
                    options = listOf("Ignored him", "Sent ministers to meet him", "Ran barefoot, embraced him, and washed his feet", "Gave a small coin"),
                    correctOptionIndex = 2,
                    explanation = "Krishna ran out barefoot, embraced Sudama warmly, and washed his feet with utmost respect."
                )
            )
        ),

        KrishnaStory(
            id = "ks_putana_redemption",
            chapter = 8,
            title = "Putana's Redemption: The Motherly Gift",
            subtitle = "Demoness Putana's trickery transformed by Krishna's boundless grace",
            moralLesson = "Divine grace looks beyond past faults to reward whatever love, however small, is offered.",
            quote = "\"Even if one approaches the Divine in disguise, true love earns eternal peace.\"",
            emoji = "✨",
            accentColorHex = 0xFF8E24AA,
            readingTimeMinutes = 3,
            summary = "King Kamsa dispatches the shapeshifting demoness Putana to Gokul to harm baby Krishna. Transforming into a beautiful maiden, she enters the cradle, but infant Krishna drinks her poison and liberates her soul with motherly salvation.",
            fullStoryParagraphs = listOf(
                "Terrified by rumors of a divine boy growing up in Gokul, tyrant Kamsa commanded the dreaded witch Putana, who possessed the ability to shift shapes at will, to eliminate all infants in the kingdom.",
                "Disguising herself as a radiant, heavenly maiden adorned with jasmine flowers and glistening silk robes, Putana slipped unnoticed into Nanda Baba's courtyard in Gokul. The cowherd maidens mistook her for the goddess of fortune Lakshmi and stepped aside.",
                "Approaching the carved wooden cradle where baby Krishna lay kicking his little feet, Putana offered him poisoned milk. Little Krishna, aware of her inner truth, closed his eyes and began drinking.",
                "As Krishna drank, he absorbed not only the poison but all the negative karma and darkness within Putana's soul. Unable to endure the divine touch, Putana's disguise shattered, revealing her towering monstrous form.",
                "Falling to the ground outside the village without harming anyone, her spirit was liberated and purified. Because she had approached Krishna in the role of a nursing mother, Krishna granted her the eternal status of a motherly soul in the heavenly abode, teaching that the Divine rewards any spark of love, even if initially masked by ignorance."
            ),
            audioTrackName = "Grace & Redemption • Shanti Chants & Flute",
            relatedYouTubeVideoId = "w1y1gA_4XHQ",
            tags = listOf("Putana", "Gokul", "Redemption", "Baby Krishna"),
            quiz = listOf(
                KrishnaQuizQuestion(
                    question = "Who sent Putana to Gokul?",
                    options = listOf("King Kamsa", "King Janaka", "Indra", "Sage Narada"),
                    correctOptionIndex = 0,
                    explanation = "The fearful tyrant King Kamsa sent Putana to Gokul."
                ),
                KrishnaQuizQuestion(
                    question = "What disguise did Putana adopt when entering Gokul?",
                    options = listOf("An old beggar", "A beautiful, radiant maiden with flowers", "A cowherd boy", "A queen"),
                    correctOptionIndex = 1,
                    explanation = "She took the form of a celestial maiden so nobody would suspect her."
                ),
                KrishnaQuizQuestion(
                    question = "What eternal status did Krishna mercifully grant Putana's soul?",
                    options = listOf("A warrior", "A tree", "A motherly soul in the divine realm", "A river"),
                    correctOptionIndex = 2,
                    explanation = "Because she offered milk as a mother, Krishna granted her motherly liberation."
                )
            )
        )
    )

    fun getStoryById(id: String): KrishnaStory? = stories.find { it.id == id }
}
