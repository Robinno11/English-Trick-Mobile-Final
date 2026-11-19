package com.example.appmobileenglishtrick.data.repository.content

import com.example.appmobileenglishtrick.data.model.BaseQuestion
import com.example.appmobileenglishtrick.data.model.DifficultyLevel
import com.example.appmobileenglishtrick.data.model.ListeningQuestion
import com.example.appmobileenglishtrick.data.model.ReadingQuestion
import com.example.appmobileenglishtrick.data.model.SpeakingQuestion
import com.example.appmobileenglishtrick.data.model.TestCategory

/**
 * Speaking Booster content: real-life conversation & fluency practice.
 * Every level has 2 Listening, 1 Reading and 3 Speaking questions (speaking is the focus).
 */
internal val speakingBoosterQuestions: List<BaseQuestion> = listOf(

    // ===== LEVEL 1 =====
    // Topics: greetings, introductions, polite basics

    // Listening
    ListeningQuestion(
        id = "booster_l1_listen_1",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_1,
        audioTitle = "First Day in Class",
        audioSpeaker = "New Classmate",
        audioScript = "Hi, I'm Daniel. I'm new here. Nice to meet you.",
        questionText = "What is the speaker doing?",
        options = listOf(
            "Saying goodbye",
            "Introducing himself",
            "Asking for directions",
            "Ordering food"
        ),
        correctIndex = 1,
        explanation = "Pembicara berkata 'Hi, I'm Daniel. I'm new here. Nice to meet you.' Ia menyebutkan nama dan mengatakan dirinya baru, jadi ia sedang memperkenalkan diri."
    ),
    ListeningQuestion(
        id = "booster_l1_listen_2",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_1,
        audioTitle = "Morning Greeting",
        audioSpeaker = "Neighbor",
        audioScript = "Good morning! How are you today?",
        questionText = "What is the best reply?",
        options = listOf(
            "My name is Lisa.",
            "Good night, see you.",
            "I'm fine, thank you. And you?",
            "Yes, I like it."
        ),
        correctIndex = 2,
        explanation = "Tetangga bertanya 'How are you today?' (Apa kabar hari ini?). Jawaban yang tepat dan sopan adalah 'I'm fine, thank you. And you?'"
    ),

    // Reading
    ReadingQuestion(
        id = "booster_l1_read_1",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_1,
        passageTitle = "A Short Chat",
        passageText = "Sara: Hi! I'm Sara. What's your name?\nBudi: Hi Sara, I'm Budi. Nice to meet you.\nSara: Nice to meet you too!",
        questionText = "What are Sara and Budi doing?",
        options = listOf(
            "Shopping for clothes",
            "Saying goodbye",
            "Ordering food",
            "Meeting and introducing themselves"
        ),
        correctIndex = 3,
        explanation = "Sara menanyakan nama ('What's your name?') dan keduanya berkata 'Nice to meet you', ungkapan saat pertama kali berkenalan. Jadi mereka sedang berkenalan."
    ),

    // Speaking
    SpeakingQuestion(
        id = "booster_l1_speak_1",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_1,
        title = "Nice to Meet You",
        context = "Kamu bertemu teman baru untuk pertama kali. Ucapkan kalimat berikut dengan ramah.",
        targetSentence = "Hello, nice to meet you.",
        tip = "Sambungkan 'meet you' menjadi seperti 'mee-chu'. Beri tekanan pada kata 'nice' dan 'meet', lalu akhiri dengan nada turun yang ramah."
    ),
    SpeakingQuestion(
        id = "booster_l1_speak_2",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_1,
        title = "Asking How Someone Is",
        context = "Kamu menyapa tetangga di pagi hari dan ingin menanyakan kabarnya. Ucapkan kalimat berikut.",
        targetSentence = "How are you doing today?",
        tip = "'How are you' diucapkan cepat dan menyambung seperti 'how-wa-ryu'. Tekankan kata 'doing' dan 'today'. Ini pertanyaan Wh-, jadi nadanya turun di akhir."
    ),
    SpeakingQuestion(
        id = "booster_l1_speak_3",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_1,
        title = "Our Motto",
        context = "Ucapkan motto English Trick dengan lantang dan penuh semangat!",
        targetSentence = "English Trick No Speak No Trick.",
        tip = "Ucapkan 'Trick' dengan bunyi 'tr' yang jelas dan 'ck' pendek di akhir. 'Speak' memakai vokal panjang 'iii'. Beri jeda kecil setelah 'English Trick' agar terdengar mantap."
    ),

    // ===== LEVEL 2 =====
    // Topics: ordering food, shopping, asking directions

    // Listening
    ListeningQuestion(
        id = "booster_l2_listen_1",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_2,
        audioTitle = "At the Cafe",
        audioSpeaker = "Waiter",
        audioScript = "Hi, welcome to Green Cafe. Are you ready to order, or do you need a few more minutes?",
        questionText = "What does the waiter want to know?",
        options = listOf(
            "Whether the customer is ready to order",
            "How the customer will pay",
            "Where the customer lives",
            "Whether the customer likes the music"
        ),
        correctIndex = 0,
        explanation = "Pelayan bertanya 'Are you ready to order, or do you need a few more minutes?' Artinya ia ingin tahu apakah pelanggan sudah siap memesan."
    ),
    ListeningQuestion(
        id = "booster_l2_listen_2",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_2,
        audioTitle = "Finding the Post Office",
        audioSpeaker = "Local Resident",
        audioScript = "Go straight for two blocks, then turn left at the bank. The post office is next to the bakery.",
        questionText = "Where is the post office?",
        options = listOf(
            "Across from the bank",
            "Two blocks to the right",
            "Behind the bakery",
            "Next to the bakery"
        ),
        correctIndex = 3,
        explanation = "Pembicara berkata 'The post office is next to the bakery.' Jadi kantor pos berada di sebelah toko roti. Bank hanya patokan untuk belok kiri."
    ),

    // Reading
    ReadingQuestion(
        id = "booster_l2_read_1",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_2,
        passageTitle = "At the Clothing Store",
        passageText = "Customer: Excuse me, do you have this T-shirt in a larger size?\nShop Assistant: Yes, we have it in large and extra large. Would you like to try it on?\nCustomer: Yes, please. Where is the fitting room?",
        questionText = "What will the customer probably do next?",
        options = listOf(
            "Pay for the T-shirt immediately",
            "Leave the store",
            "Try on the T-shirt",
            "Ask for a smaller size"
        ),
        correctIndex = 2,
        explanation = "Pelanggan menjawab 'Yes, please' saat ditawari mencoba baju, lalu bertanya 'Where is the fitting room?' (kamar pas). Jadi ia akan mencoba kaos tersebut."
    ),

    // Speaking
    SpeakingQuestion(
        id = "booster_l2_speak_1",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_2,
        title = "Ordering Food",
        context = "Kamu di restoran cepat saji dan ingin memesan makanan. Ucapkan kalimat berikut.",
        targetSentence = "Can I have a chicken burger, please?",
        tip = "Sambungkan 'Can I' menjadi 'ca-nai' dan 'have a' menjadi 'ha-va'. Tekankan 'chicken burger'. Gunakan nada naik di akhir karena ini permintaan sopan."
    ),
    SpeakingQuestion(
        id = "booster_l2_speak_2",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_2,
        title = "Asking the Price",
        context = "Kamu sedang berbelanja dan ingin tahu harga sebuah jaket biru. Ucapkan kalimat berikut.",
        targetSentence = "How much is this blue jacket?",
        tip = "'Much is' disambung menjadi 'mu-chiz'. Bunyi 'j' pada 'jacket' seperti 'j' dalam bahasa Indonesia, dan tekanan ada di suku kata pertama: JA-ket."
    ),
    SpeakingQuestion(
        id = "booster_l2_speak_3",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_2,
        title = "Asking for Directions",
        context = "Kamu tersesat di kota dan ingin bertanya arah ke stasiun kepada orang yang lewat. Ucapkan kalimat berikut.",
        targetSentence = "Excuse me, how do I get to the station?",
        tip = "Mulai dengan 'Excuse me' yang sopan (tekanan di 'CUSE'). 'Get to' diucapkan cepat seperti 'ge-tu'. Tekankan kata 'station': STA-tion."
    ),

    // ===== LEVEL 3 =====
    // Topics: travel, phone calls, making arrangements, small talk

    // Listening
    ListeningQuestion(
        id = "booster_l3_listen_1",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_3,
        audioTitle = "Hotel Check-in",
        audioSpeaker = "Hotel Receptionist",
        audioScript = "Good evening, and welcome to the Ocean View Hotel. Could I see your passport and the credit card you used for the booking, please? Your room is on the fifth floor, and breakfast is served from six thirty until ten in the restaurant next to the lobby.",
        questionText = "When does breakfast finish?",
        options = listOf(
            "At six thirty",
            "At ten",
            "At five",
            "At nine thirty"
        ),
        correctIndex = 1,
        explanation = "Resepsionis berkata 'breakfast is served from six thirty until ten'. Jadi sarapan berakhir pukul sepuluh. 'Fifth floor' adalah lantai kamar, bukan jam."
    ),
    ListeningQuestion(
        id = "booster_l3_listen_2",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_3,
        audioTitle = "A Phone Message",
        audioSpeaker = "Clinic Assistant",
        audioScript = "Hi, this is Maya from Doctor Smith's office. I'm calling to let you know that your appointment on Tuesday has been moved to Thursday at the same time. Please call us back if that doesn't work for you.",
        questionText = "Why is the speaker calling?",
        options = listOf(
            "To cancel the appointment completely",
            "To ask for payment",
            "To book a new patient",
            "To change the day of an appointment"
        ),
        correctIndex = 3,
        explanation = "Maya berkata 'your appointment on Tuesday has been moved to Thursday at the same time'. Jadi ia menelepon untuk memindahkan hari janji temu, bukan membatalkannya."
    ),

    // Reading
    ReadingQuestion(
        id = "booster_l3_read_1",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_3,
        passageTitle = "Text Message: Change of Plans",
        passageText = "Hey Tom! Change of plans for Saturday. The museum is closed for repairs, so how about the cinema instead? The movie starts at 4, so let's meet at the mall entrance at 3:30. Text me if you can't make it!",
        questionText = "What should Tom do if he cannot come?",
        options = listOf(
            "Send a text message",
            "Go to the museum",
            "Wait at the mall entrance",
            "Buy the movie tickets"
        ),
        correctIndex = 0,
        explanation = "Pesan diakhiri dengan 'Text me if you can't make it!' Ungkapan 'can't make it' berarti tidak bisa datang, jadi Tom harus mengirim pesan teks."
    ),

    // Speaking
    SpeakingQuestion(
        id = "booster_l3_speak_1",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_3,
        title = "Calling a Hotel",
        context = "Kamu menelepon hotel untuk menanyakan reservasimu. Perkenalkan dirimu dengan kalimat berikut.",
        targetSentence = "Hi, this is Rina calling about my hotel reservation for Friday.",
        tip = "Di telepon, gunakan 'This is ...', bukan 'I am ...'. Tekankan 'reservation' di suku kata 'VA': re-ser-VA-tion. Ucapkan 'Friday' dengan jelas karena itu informasi penting."
    ),
    SpeakingQuestion(
        id = "booster_l3_speak_2",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_3,
        title = "At the Airport",
        context = "Kamu di konter check-in bandara dan ingin meminta kursi dekat jendela. Ucapkan kalimat berikut.",
        targetSentence = "I'd like a window seat on the morning flight, please.",
        tip = "'I'd like a' disambung menjadi 'ai-lai-ka'. Bedakan 'seat' (vokal panjang 'iii') dengan 'sit'. Tekankan 'window seat' dan 'morning flight'."
    ),
    SpeakingQuestion(
        id = "booster_l3_speak_3",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_3,
        title = "Making Plans",
        context = "Kamu ingin mengajak teman minum kopi akhir pekan ini. Ucapkan kalimat berikut dengan santai.",
        targetSentence = "Are you free on Saturday afternoon to grab some coffee?",
        tip = "'Grab some coffee' adalah ungkapan santai untuk minum kopi bersama. 'Free on' disambung menjadi 'free-yon'. Gunakan nada naik di akhir karena ini pertanyaan yes/no."
    ),

    // ===== LEVEL 4 =====
    // Topics: work/school situations, opinions, polite disagreement, idioms

    // Listening
    ListeningQuestion(
        id = "booster_l4_listen_1",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_4,
        audioTitle = "Team Update",
        audioSpeaker = "Team Leader",
        audioScript = "Okay everyone, I know we're all a bit tired, but the client has moved the deadline up to Friday. So I'm afraid we'll have to put the new design on the back burner and focus on finishing the report first. Let's touch base again tomorrow morning.",
        questionText = "What will the team do with the new design?",
        options = listOf(
            "Finish it before Friday",
            "Send it to the client today",
            "Delay it until later",
            "Cancel it permanently"
        ),
        correctIndex = 2,
        explanation = "Ketua tim berkata 'put the new design on the back burner'. Idiom 'on the back burner' berarti menunda sesuatu karena ada prioritas lain, yaitu menyelesaikan laporan lebih dulu."
    ),
    ListeningQuestion(
        id = "booster_l4_listen_2",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_4,
        audioTitle = "Online or In Person?",
        audioSpeaker = "Coworker",
        audioScript = "Honestly, I see why you want to keep all our meetings online, it really saves time. But I think some topics are easier to discuss face to face. So maybe we could meet in person just once a month?",
        questionText = "What is the speaker's attitude toward the idea?",
        options = listOf(
            "Completely agrees with no changes",
            "Partly agrees and suggests a compromise",
            "Strongly rejects it and gets angry",
            "Has no opinion about it"
        ),
        correctIndex = 1,
        explanation = "Pembicara mengakui kelebihan ide itu ('I see why... it really saves time'), lalu menyampaikan keberatan dengan 'But I think...' dan memberi usulan tengah 'maybe we could meet in person just once a month'. Jadi ia setuju sebagian dan menawarkan kompromi."
    ),

    // Reading
    ReadingQuestion(
        id = "booster_l4_read_1",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_4,
        passageTitle = "Three Tips for Disagreeing Politely",
        passageText = "Disagreeing with a colleague doesn't have to sound rude. First, acknowledge the other person's idea with phrases like 'That's a fair point' or 'I see where you're coming from.' Second, use softeners such as 'I'm not sure' or 'Maybe we could' instead of saying 'You're wrong.' Finally, offer an alternative so the conversation moves forward rather than stopping at 'no.'",
        questionText = "Your colleague suggests that everyone works late every day this week. Which reply best follows the tips?",
        options = listOf(
            "No, that's a bad idea.",
            "You're wrong, we don't need to do that.",
            "Whatever, do what you want.",
            "I see where you're coming from, but maybe we could split the tasks instead?"
        ),
        correctIndex = 3,
        explanation = "Jawaban ini memenuhi ketiga tips: mengakui ide ('I see where you're coming from'), memakai pelunak ('maybe we could'), dan memberi alternatif ('split the tasks'). Pilihan lain terdengar kasar atau tidak menawarkan solusi."
    ),

    // Speaking
    SpeakingQuestion(
        id = "booster_l4_speak_1",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_4,
        title = "Giving an Opinion",
        context = "Dalam diskusi kelas, kamu diminta memberikan pendapat tentang cara belajar bahasa Inggris. Ucapkan kalimat berikut.",
        targetSentence = "In my opinion, students should spend more time speaking English than memorizing grammar rules.",
        tip = "Beri jeda singkat setelah 'In my opinion'. Tekankan kata kunci 'speaking' dan 'memorizing' untuk menunjukkan perbandingan. 'Should' diucapkan lemah seperti 'shud'."
    ),
    SpeakingQuestion(
        id = "booster_l4_speak_2",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_4,
        title = "Disagreeing Politely",
        context = "Rekan kerjamu mengusulkan solusi yang menurutmu kurang tepat. Sampaikan ketidaksetujuan dengan sopan menggunakan kalimat berikut.",
        targetSentence = "I see your point, but I'm not sure that's the best solution for our team.",
        tip = "Gunakan nada lembut dan jangan terlalu keras di 'but'. 'Not sure' diucapkan menyambung 'nat-shur'. Tekankan 'best solution' agar maksudmu jelas tanpa terdengar kasar."
    ),
    SpeakingQuestion(
        id = "booster_l4_speak_3",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_4,
        title = "Calling It a Day",
        context = "Rapat sudah berjalan lama dan semua orang lelah. Usulkan untuk berhenti dan melanjutkan besok dengan idiom berikut.",
        targetSentence = "Let's call it a day and pick this up again tomorrow morning.",
        tip = "Idiom 'call it a day' berarti berhenti bekerja untuk hari ini. Sambungkan 'call it a' menjadi 'caw-li-ta' dan 'pick this up' menjadi 'pik-thi-sup'. Tekankan 'day' dan 'tomorrow'."
    ),

    // ===== LEVEL 5 =====
    // Topics: job interviews, presentations, negotiation, formal & persuasive speech

    // Listening
    ListeningQuestion(
        id = "booster_l5_listen_1",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_5,
        audioTitle = "The Interview",
        audioSpeaker = "Interviewer",
        audioScript = "Thank you for coming in today. I've had a look at your portfolio, and I have to say your design work is impressive. However, this role involves leading a small team, and I noticed you haven't officially managed people before. Could you tell me about a time you took the initiative to guide others, even without a formal title? We're really looking for someone who can motivate the team from day one.",
        questionText = "What is the interviewer most concerned about?",
        options = listOf(
            "The candidate's lack of leadership experience",
            "The quality of the candidate's design work",
            "The candidate's salary expectations",
            "Whether the candidate can start on day one"
        ),
        correctIndex = 0,
        explanation = "Pewawancara memuji portofolio ('your design work is impressive'), lalu berkata 'However... you haven't officially managed people before' dan meminta contoh saat kandidat memimpin orang lain. Jadi kekhawatirannya adalah kurangnya pengalaman memimpin."
    ),
    ListeningQuestion(
        id = "booster_l5_listen_2",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_5,
        audioTitle = "Closing the Deal",
        audioSpeaker = "Supplier Representative",
        audioScript = "I completely understand that your budget is tight this quarter. Unfortunately, we can't lower the unit price any further, as our material costs have gone up significantly. What we can do, though, is offer free delivery and extend your payment period from thirty to sixty days. And if you're able to commit to a twelve-month contract, I could also include a dedicated account manager at no extra cost. I think that would give you real value without compromising on quality.",
        questionText = "What can be inferred about the speaker's negotiation strategy?",
        options = listOf(
            "The speaker is willing to cut the price if the client complains",
            "The speaker wants to end the business relationship",
            "The speaker refuses to offer anything new",
            "The speaker keeps the price fixed but adds other benefits to close the deal"
        ),
        correctIndex = 3,
        explanation = "Pembicara menolak menurunkan harga ('we can't lower the unit price any further'), tetapi menawarkan pengiriman gratis, tenggat pembayaran lebih panjang, dan account manager gratis. Ini strategi mempertahankan harga sambil menambah nilai agar kesepakatan tercapai."
    ),

    // Reading
    ReadingQuestion(
        id = "booster_l5_read_1",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_5,
        passageTitle = "Email: Following Up After an Interview",
        passageText = "Dear Ms. Hartono,\n\nThank you for taking the time to meet with me on Monday to discuss the Marketing Coordinator position. I truly enjoyed learning about your team's upcoming product launch, and our conversation reinforced my enthusiasm for the role. As we discussed, my experience managing social media campaigns could help your team reach a younger audience. Please do not hesitate to contact me should you require any further information.\n\nKind regards,\nAndi Pratama",
        questionText = "What is the main purpose of this email?",
        options = listOf(
            "To formally accept a job offer made during the interview",
            "To request a second interview because the first one went poorly",
            "To express gratitude and subtly remind the interviewer of a relevant strength",
            "To negotiate the salary and benefits discussed on Monday"
        ),
        correctIndex = 2,
        explanation = "Andi berterima kasih ('Thank you for taking the time to meet with me') dan secara halus mengingatkan keunggulannya ('my experience managing social media campaigns could help your team'). Tidak ada penerimaan tawaran, permintaan wawancara ulang, atau negosiasi gaji."
    ),

    // Speaking
    SpeakingQuestion(
        id = "booster_l5_speak_1",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_5,
        title = "Selling Yourself",
        context = "Dalam wawancara kerja, pewawancara bertanya mengapa kamu cocok untuk posisi ini. Jawab dengan percaya diri menggunakan kalimat berikut.",
        targetSentence = "I'm confident that my experience in customer service and teamwork makes me a strong candidate for this position.",
        tip = "Ucapkan dengan tempo stabil dan percaya diri. Tekankan 'confident', 'experience', dan 'strong candidate'. Perhatikan tekanan kata: con-FI-dent, ex-PE-ri-ence, po-SI-tion."
    ),
    SpeakingQuestion(
        id = "booster_l5_speak_2",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_5,
        title = "Concluding a Presentation",
        context = "Kamu sedang menutup presentasi di depan manajer. Sampaikan kesimpulan dengan meyakinkan menggunakan kalimat berikut.",
        targetSentence = "To sum up, our data clearly shows that investing in staff training leads to higher customer satisfaction.",
        tip = "Beri jeda setelah 'To sum up' untuk menarik perhatian audiens. Tekankan 'clearly', 'investing', dan 'satisfaction' (sa-tis-FAC-tion). Turunkan nada di akhir agar terdengar tegas."
    ),
    SpeakingQuestion(
        id = "booster_l5_speak_3",
        category = TestCategory.SPEAKING_BOOSTER,
        level = DifficultyLevel.LEVEL_5,
        title = "Negotiating a Deal",
        context = "Kamu bernegosiasi dengan pemasok. Tolak tawarannya dengan sopan dan ajukan syaratmu menggunakan kalimat berikut.",
        targetSentence = "We appreciate your offer, but we would need a ten percent discount to move forward with this contract.",
        tip = "Mulai dengan nada hangat pada 'We appreciate your offer' (ap-PRE-ci-ate), lalu ucapkan syarat dengan tegas. Tekankan 'ten percent discount'. 'Move forward' berarti melanjutkan kesepakatan."
    )
)
