package com.example.appmobileenglishtrick.data.repository.content

import com.example.appmobileenglishtrick.data.model.BaseQuestion
import com.example.appmobileenglishtrick.data.model.DifficultyLevel
import com.example.appmobileenglishtrick.data.model.ListeningQuestion
import com.example.appmobileenglishtrick.data.model.ReadingQuestion
import com.example.appmobileenglishtrick.data.model.SpeakingQuestion
import com.example.appmobileenglishtrick.data.model.TestCategory

internal val teensQuestions: List<BaseQuestion> = listOf(

    // ===== LEVEL 1 =====

    // Listening
    ListeningQuestion(
        id = "teens_l1_listen_1",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_1,
        audioTitle = "New Student",
        audioSpeaker = "Kevin",
        audioScript = "Hi, everyone. My name is Kevin. I am fourteen years old. I am from Bandung. I like playing the guitar.",
        questionText = "How old is Kevin?",
        options = listOf("Thirteen", "Fourteen", "Fifteen", "Sixteen"),
        correctIndex = 1,
        explanation = "Kevin mengatakan: 'I am fourteen years old.' Jadi umurnya empat belas tahun."
    ),
    ListeningQuestion(
        id = "teens_l1_listen_2",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_1,
        audioTitle = "My Hobby",
        audioSpeaker = "Sarah",
        audioScript = "Hello, I am Sarah. I love sports. I play badminton every Sunday with my sister. It is my favorite hobby.",
        questionText = "What sport does Sarah play?",
        options = listOf("Football", "Swimming", "Badminton", "Basketball"),
        correctIndex = 2,
        explanation = "Sarah mengatakan: 'I play badminton every Sunday with my sister.'"
    ),

    // Reading
    ReadingQuestion(
        id = "teens_l1_read_1",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_1,
        passageTitle = "My Best Friend",
        passageText = "My best friend is Dimas. He is in my class at school. He likes drawing and reading comics.",
        questionText = "What does Dimas like?",
        options = listOf("Drawing and reading comics", "Singing and dancing", "Cooking and swimming", "Playing games and running"),
        correctIndex = 0,
        explanation = "Teks menyebutkan: 'He likes drawing and reading comics.'"
    ),
    ReadingQuestion(
        id = "teens_l1_read_2",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_1,
        passageTitle = "My School Bag",
        passageText = "I have a blue school bag. In my bag, there are three books, a pencil case, and a water bottle. I take it to school every day.",
        questionText = "What color is the school bag?",
        options = listOf("Red", "Black", "Green", "Blue"),
        correctIndex = 3,
        explanation = "Teks menyebutkan: 'I have a blue school bag.' Jadi warnanya biru."
    ),

    // Speaking
    SpeakingQuestion(
        id = "teens_l1_speak_1",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_1,
        title = "Talk About Your Hobby",
        context = "Ceritakan hobimu sepulang sekolah. Ucapkan kalimat berikut dengan jelas.",
        targetSentence = "I like playing basketball after school.",
        tip = "Ucapkan 'basketball' dengan tekanan di suku kata pertama: BAS-ket-ball."
    ),
    SpeakingQuestion(
        id = "teens_l1_speak_2",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_1,
        title = "Favorite Subject",
        context = "Sebutkan pelajaran favoritmu di sekolah.",
        targetSentence = "My favorite subject is English.",
        tip = "Kata 'favorite' diucapkan FAY-vuh-rit, dan 'subject' diberi tekanan di awal: SUB-ject."
    ),

    // ===== LEVEL 2 =====

    // Listening
    ListeningQuestion(
        id = "teens_l2_listen_1",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_2,
        audioTitle = "School Announcement",
        audioSpeaker = "Mr. Hadi (Teacher)",
        audioScript = "Good morning, students. This is a short announcement. The science club meets today after school in Room twelve. The meeting starts at three fifteen. Please bring your notebooks.",
        questionText = "What time does the meeting start?",
        options = listOf("At two thirty", "At three o'clock", "At four fifteen", "At three fifteen"),
        correctIndex = 3,
        explanation = "Pak Hadi mengatakan: 'The meeting starts at three fifteen.'"
    ),
    ListeningQuestion(
        id = "teens_l2_listen_2",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_2,
        audioTitle = "My Weekend",
        audioSpeaker = "Jake",
        audioScript = "Last weekend was great. On Saturday, I visited my grandparents in the village. On Sunday, I went to the cinema with my cousin. We watched a funny movie and ate popcorn.",
        questionText = "What did Jake do on Saturday?",
        options = listOf("He visited his grandparents", "He went to the cinema", "He played football", "He stayed at home"),
        correctIndex = 0,
        explanation = "Jake mengatakan: 'On Saturday, I visited my grandparents in the village.' Ke bioskop dilakukan pada hari Minggu."
    ),

    // Reading
    ReadingQuestion(
        id = "teens_l2_read_1",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_2,
        passageTitle = "Message from Lisa",
        passageText = "Hi Tom, I can't come to band practice today because I have a dentist appointment at four. Can we practice tomorrow instead? I finish school at two, so I am free after that. Please tell the others. Thanks, Lisa.",
        questionText = "Why can't Lisa come to band practice today?",
        options = listOf("She has a lot of homework", "She is sick", "She has a dentist appointment", "She has a football match"),
        correctIndex = 2,
        explanation = "Teks menyebutkan: 'I can't come to band practice today because I have a dentist appointment at four.'"
    ),
    ReadingQuestion(
        id = "teens_l2_read_2",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_2,
        passageTitle = "Maya's Morning Routine",
        passageText = "Maya wakes up at five thirty every morning. She takes a shower and has breakfast with her family. Then she rides her bike to school. School starts at seven o'clock.",
        questionText = "How does Maya go to school?",
        options = listOf("By bus", "By bike", "On foot", "By car"),
        correctIndex = 1,
        explanation = "Teks menyebutkan: 'Then she rides her bike to school.' Jadi Maya naik sepeda."
    ),

    // Speaking
    SpeakingQuestion(
        id = "teens_l2_speak_1",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_2,
        title = "Daily Routine",
        context = "Ceritakan jam berapa kamu biasanya bangun pagi.",
        targetSentence = "I usually get up at six thirty every morning.",
        tip = "Bedakan bunyi 'thirty' (TH lembut, lidah di antara gigi) dengan 'dirty'. Ucapkan 'usually' sebagai YOO-zhoo-uh-lee."
    ),
    SpeakingQuestion(
        id = "teens_l2_speak_2",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_2,
        title = "Last Weekend",
        context = "Ceritakan apa yang kamu lakukan kemarin bersama teman-temanmu.",
        targetSentence = "Yesterday I watched a movie with my friends.",
        tip = "Akhiran '-ed' pada 'watched' dibaca /t/, jadi terdengar 'watcht', bukan 'watch-ed'."
    ),

    // ===== LEVEL 3 =====

    // Listening
    ListeningQuestion(
        id = "teens_l3_listen_1",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_3,
        audioTitle = "Weekend Plans",
        audioSpeaker = "Nadia",
        audioScript = "Hey Rizky, are you free this Saturday? I was thinking we could go to the city park and practice skateboarding. I have just bought a new skateboard, and I really want to try it. If it rains, we can go to the shopping mall and watch a movie instead. Let me know tonight, okay?",
        questionText = "What will they do if it rains?",
        options = listOf("Practice skateboarding at home", "Stay home and play games", "Go to the mall and watch a movie", "Go to the city park anyway"),
        correctIndex = 2,
        explanation = "Nadia mengatakan: 'If it rains, we can go to the shopping mall and watch a movie instead.'"
    ),
    ListeningQuestion(
        id = "teens_l3_listen_2",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_3,
        audioTitle = "A Trip to Remember",
        audioSpeaker = "Daniel",
        audioScript = "I have traveled to many places, but my trip to Lombok last year was the best. My family and I stayed near the beach for five days. I have never seen water so clear. On the third day, I tried snorkeling for the first time, and I saw a sea turtle. I have wanted to go back ever since.",
        questionText = "What did Daniel do for the first time?",
        options = listOf("He went surfing", "He tried snorkeling", "He climbed a mountain", "He rode a boat"),
        correctIndex = 1,
        explanation = "Daniel mengatakan: 'On the third day, I tried snorkeling for the first time.'"
    ),

    // Reading
    ReadingQuestion(
        id = "teens_l3_read_1",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_3,
        passageTitle = "Email: School Trip",
        passageText = "Dear Students, the Grade 9 trip to the National Science Museum will take place next Friday. The bus will leave the school at seven thirty in the morning, so please arrive by seven fifteen. Lunch will be provided, but you should bring your own water bottle. Remember to wear your school uniform and comfortable shoes. Students who have not returned the permission form must give it to their homeroom teacher by Wednesday. Best regards, Ms. Rivera.",
        questionText = "What must students do by Wednesday?",
        options = listOf("Pay for their lunch", "Buy a museum ticket", "Bring a water bottle", "Return the permission form"),
        correctIndex = 3,
        explanation = "Teks menyebutkan: 'Students who have not returned the permission form must give it to their homeroom teacher by Wednesday.'"
    ),
    ReadingQuestion(
        id = "teens_l3_read_2",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_3,
        passageTitle = "The Lost Phone",
        passageText = "Last Monday, Alya couldn't find her phone after basketball practice. She looked in her bag, in the classroom, and in the cafeteria, but it wasn't there. She felt worried because all her photos were on it. The next morning, the school guard called her name during the assembly. Someone had found her phone on the bench next to the basketball court and had given it to him. Alya has been more careful with her things since then.",
        questionText = "Where was Alya's phone found?",
        options = listOf("On a bench next to the basketball court", "In the cafeteria", "In her classroom", "In the guard's office"),
        correctIndex = 0,
        explanation = "Teks menyebutkan: 'Someone had found her phone on the bench next to the basketball court.'"
    ),

    // Speaking
    SpeakingQuestion(
        id = "teens_l3_speak_1",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_3,
        title = "Travel Dreams",
        context = "Ceritakan tempat yang belum pernah kamu kunjungi tetapi ingin kamu datangi.",
        targetSentence = "I have never been to Bali, but I really want to go.",
        tip = "Dalam ucapan cepat, 'I have' sering disingkat menjadi 'I've'. Beri jeda singkat sebelum kata 'but'."
    ),
    SpeakingQuestion(
        id = "teens_l3_speak_2",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_3,
        title = "Making Plans",
        context = "Ajak temanmu belajar bersama di perpustakaan akhir pekan ini.",
        targetSentence = "Would you like to study together at the library this weekend?",
        tip = "'Would you' diucapkan menyambung seperti 'wood-joo'. Gunakan intonasi naik di akhir karena ini pertanyaan ya/tidak."
    ),

    // ===== LEVEL 4 =====

    // Listening
    ListeningQuestion(
        id = "teens_l4_listen_1",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_4,
        audioTitle = "Should Homework Be Banned?",
        audioSpeaker = "Olivia (Student Debater)",
        audioScript = "Many people say homework should be banned, but I don't completely agree. Of course, too much homework can stress students out and take away time from hobbies and family. However, a small amount of homework helps us review what we learned and builds good study habits. In my view, schools shouldn't get rid of homework. Instead, teachers should cut down on the amount and make it more meaningful.",
        questionText = "What is the speaker's main opinion?",
        options = listOf(
            "Homework should be reduced, not removed",
            "Homework should be banned completely",
            "Students should get more homework",
            "Homework is only useful for science"
        ),
        correctIndex = 0,
        explanation = "Olivia mengatakan: 'schools shouldn't get rid of homework. Instead, teachers should cut down on the amount.' Jadi PR sebaiknya dikurangi, bukan dihapus."
    ),
    ListeningQuestion(
        id = "teens_l4_listen_2",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_4,
        audioTitle = "Team Tryouts",
        audioSpeaker = "Coach Martin",
        audioScript = "Alright, listen up, everyone. Tryouts for the volleyball team have been put off until next Thursday because the gym floor is being repaired. I know some of you were looking forward to today, so thanks for your patience. Use the extra time to work on your serves. And please don't give up if you don't make the team this year. Several of our best players were turned down the first time they tried.",
        questionText = "Why does the coach mention players who were turned down before?",
        options = listOf(
            "To explain the rules of the tryouts",
            "To warn students that the team is full",
            "To complain about last year's team",
            "To encourage students not to give up"
        ),
        correctIndex = 3,
        explanation = "Pelatih berkata: 'please don't give up if you don't make the team this year. Several of our best players were turned down the first time.' Tujuannya untuk menyemangati siswa."
    ),

    // Reading
    ReadingQuestion(
        id = "teens_l4_read_1",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_4,
        passageTitle = "Online Friends vs. Real-Life Friends",
        passageText = "Today, many teenagers have friends they have only met online. Some adults worry that these friendships are not real, but the truth is more complicated. Online friends can share interests that people around us may not have, such as a rare hobby or a favorite band. They can also offer support to teens who feel lonely at school. On the other hand, it is harder to know whether someone online is honest about who they are. Face-to-face friends, meanwhile, can be there for us physically when we need help. Perhaps the best approach is not to choose one over the other, but to keep a healthy balance and stay safe online.",
        questionText = "What can be inferred about the writer's view?",
        options = listOf(
            "Online friendships are always dangerous",
            "Both types of friendship have value",
            "Real-life friends are no longer important",
            "Teenagers should stop using social media"
        ),
        correctIndex = 1,
        explanation = "Penulis menyebutkan kelebihan dan kekurangan keduanya, lalu menyimpulkan: 'the best approach is not to choose one over the other, but to keep a healthy balance.'"
    ),
    ReadingQuestion(
        id = "teens_l4_read_2",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_4,
        passageTitle = "From Hobby to Career",
        passageText = "When Rafi was twelve, he started editing short videos of his friends playing football. At first, it was just for fun, and he often ran into problems with slow software. Instead of giving up, he looked up free tutorials and practiced every weekend. By sixteen, local shops were asking him to make short promotional videos. He set up a small online portfolio to show his work. Now, at eighteen, Rafi has been accepted into a film school. He says that turning a hobby into a career takes patience more than talent.",
        questionText = "What is the main idea of the passage?",
        options = listOf(
            "Video editing software is too expensive",
            "Football is a popular topic for videos",
            "A hobby can grow into a career with patience and practice",
            "Film schools only accept talented students"
        ),
        correctIndex = 2,
        explanation = "Teks menceritakan perjalanan Rafi dari hobi hingga diterima di sekolah film, dan ditutup dengan: 'turning a hobby into a career takes patience more than talent.'"
    ),

    // Speaking
    SpeakingQuestion(
        id = "teens_l4_speak_1",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_4,
        title = "Give Your Opinion",
        context = "Sampaikan pendapatmu tentang penggunaan media sosial oleh pelajar.",
        targetSentence = "In my opinion, students should spend less time on social media every day.",
        tip = "Beri jeda setelah 'In my opinion'. Kata 'social' diucapkan SO-shul, dan 'media' diucapkan MEE-dee-uh."
    ),
    SpeakingQuestion(
        id = "teens_l4_speak_2",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_4,
        title = "Comparing Ideas",
        context = "Bandingkan kelas online dengan belajar di sekolah secara langsung.",
        targetSentence = "I think online classes are convenient, but learning at school is much more fun.",
        tip = "Tekanan kata 'convenient' ada di suku kata kedua: con-VEE-nee-ent. Tekankan juga 'much more' untuk menunjukkan perbandingan."
    ),

    // ===== LEVEL 5 =====

    // Listening
    ListeningQuestion(
        id = "teens_l5_listen_1",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_5,
        audioTitle = "The Science of Sleep",
        audioSpeaker = "Dr. Amelia Chen (Psychologist)",
        audioScript = "During adolescence, the body clock naturally shifts later, which is why many teenagers find it hard to fall asleep before eleven at night. Unfortunately, most schools start early, so teens are often running on empty by the middle of the week. Research has shown that students who get at least eight hours of sleep tend to remember information better and manage their emotions more effectively. If schools started just one hour later, attendance and test scores would probably improve. Until that happens, the best advice is to put screens away an hour before bed, since blue light delays the release of the sleep hormone melatonin.",
        questionText = "What does the expression 'running on empty' most likely mean?",
        options = listOf(
            "Running to school without breakfast",
            "Having no homework left to do",
            "Feeling hungry during class",
            "Being extremely tired with little energy left"
        ),
        correctIndex = 3,
        explanation = "Dr. Chen menjelaskan remaja kurang tidur karena sekolah dimulai pagi, sehingga 'teens are often running on empty'. Idiom ini berarti sangat lelah dan hampir kehabisan tenaga."
    ),
    ListeningQuestion(
        id = "teens_l5_listen_2",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_5,
        audioTitle = "Fast Fashion",
        audioSpeaker = "Ms. Rivera (Teacher)",
        audioScript = "Today we are looking at fast fashion, which refers to cheap, trendy clothing that is produced quickly and in huge quantities. It is estimated that the fashion industry is responsible for around ten percent of global carbon emissions. Moreover, thousands of liters of water are used to produce a single pair of jeans. Most of these clothes are worn only a few times before they are thrown away. However, consumers are not powerless. If each of us bought fewer items and chose second-hand clothes more often, the demand for fast fashion would gradually decrease. So before your next shopping trip, ask yourself whether you really need it.",
        questionText = "According to the speaker, how can consumers reduce the impact of fast fashion?",
        options = listOf(
            "By washing their clothes less often",
            "By buying fewer items and choosing second-hand clothes",
            "By only buying clothes made of cotton",
            "By throwing away old clothes more quickly"
        ),
        correctIndex = 1,
        explanation = "Bu Rivera mengatakan: 'If each of us bought fewer items and chose second-hand clothes more often, the demand for fast fashion would gradually decrease.'"
    ),

    // Reading
    ReadingQuestion(
        id = "teens_l5_read_1",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_5,
        passageTitle = "Why Our Brains Love Notifications",
        passageText = "Every time a phone buzzes with a new like or message, the brain releases a small amount of dopamine, a chemical linked to pleasure and motivation. App designers are well aware of this effect, and many features are deliberately created to keep users scrolling. Because rewards arrive at unpredictable times, the brain keeps checking for the next one, much like a player at a slot machine. Over time, this habit can make it harder for teenagers to concentrate on tasks that offer no instant reward, such as reading or studying. Studies have also suggested a link between heavy social media use and lower self-esteem. Nevertheless, experts do not recommend giving up technology entirely. Simple strategies, such as turning off non-essential notifications or setting app time limits, can help users regain control. Understanding how these apps work is the first step toward using them wisely.",
        questionText = "What is the author's main purpose in writing this text?",
        options = listOf(
            "To explain how notifications affect the brain and suggest ways to manage them",
            "To persuade teenagers to delete all their social media accounts",
            "To advertise a new app that limits screen time",
            "To describe how slot machines are designed"
        ),
        correctIndex = 0,
        explanation = "Teks menjelaskan efek dopamin dari notifikasi, lalu memberi saran: 'turning off non-essential notifications or setting app time limits'. Penulis juga menyatakan 'experts do not recommend giving up technology entirely', jadi tujuannya menjelaskan dan memberi solusi, bukan membujuk berhenti total."
    ),
    ReadingQuestion(
        id = "teens_l5_read_2",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_5,
        passageTitle = "Cities That Breathe",
        passageText = "As urban populations continue to grow, cities are becoming hotter than the surrounding countryside, a phenomenon known as the urban heat island effect. Concrete and asphalt absorb sunlight during the day and release it slowly at night, keeping temperatures high. To tackle this problem, several cities have introduced green roofs, which are rooftops covered with plants. These roofs not only cool buildings but also absorb rainwater and provide habitats for birds and insects. In Singapore, for example, vertical gardens have been installed on the walls of skyscrapers. Critics argue that such projects are costly to maintain. However, supporters point out that the long-term savings on air conditioning and health care could outweigh the initial investment. If more cities adopted these designs, urban life could become significantly more sustainable.",
        questionText = "In the passage, the word 'outweigh' is closest in meaning to...",
        options = listOf(
            "be heavier than in kilograms",
            "be equal to",
            "be less important than",
            "be greater than"
        ),
        correctIndex = 3,
        explanation = "Teks menyebutkan: 'the long-term savings ... could outweigh the initial investment.' Artinya penghematan jangka panjang bisa lebih besar daripada biaya awal, jadi 'outweigh' berarti 'be greater than'."
    ),

    // Speaking
    SpeakingQuestion(
        id = "teens_l5_speak_1",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_5,
        title = "Environmental Conditional",
        context = "Jelaskan dampak positif jika lebih banyak orang menggunakan transportasi umum.",
        targetSentence = "If more people used public transport, our cities would be cleaner, quieter, and much less crowded.",
        tip = "Gunakan intonasi naik pada klausa 'If more people used public transport', lalu turun di akhir kalimat. Ucapkan daftar 'cleaner, quieter, and' dengan ritme yang jelas."
    ),
    SpeakingQuestion(
        id = "teens_l5_speak_2",
        category = TestCategory.TEENS,
        level = DifficultyLevel.LEVEL_5,
        title = "Plastic Problem",
        context = "Sampaikan argumen tentang masalah sampah plastik menggunakan kalimat pasif.",
        targetSentence = "Plastic waste is being produced faster than it can be recycled, so we need to act now.",
        tip = "Kata 'recycled' diucapkan ree-SY-kuld dengan tekanan di suku kata kedua. Tekankan 'act now' di akhir untuk memberi kesan mendesak."
    ),
)
