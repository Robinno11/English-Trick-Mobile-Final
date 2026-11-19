package com.example.appmobileenglishtrick.data.repository.content

import com.example.appmobileenglishtrick.data.model.BaseQuestion
import com.example.appmobileenglishtrick.data.model.DifficultyLevel
import com.example.appmobileenglishtrick.data.model.ListeningQuestion
import com.example.appmobileenglishtrick.data.model.ReadingQuestion
import com.example.appmobileenglishtrick.data.model.SpeakingQuestion
import com.example.appmobileenglishtrick.data.model.TestCategory

internal val kidsQuestions: List<BaseQuestion> = listOf(
    // ===== LEVEL 1 =====
    // Listening
    ListeningQuestion(
        id = "kids_l1_listen_1",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_1,
        audioTitle = "My Pet",
        audioSpeaker = "Tom",
        audioScript = "Hello. I have a cat. My cat is black.",
        questionText = "What color is Tom's cat?",
        options = listOf("White", "Black", "Brown", "Orange"),
        correctIndex = 1,
        explanation = "Tom mengatakan: 'My cat is black.' Jadi kucingnya berwarna hitam."
    ),
    ListeningQuestion(
        id = "kids_l1_listen_2",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_1,
        audioTitle = "Fruit Time",
        audioSpeaker = "Teacher Anna",
        audioScript = "Look. I have three bananas.",
        questionText = "How many bananas does Teacher Anna have?",
        options = listOf("One", "Two", "Five", "Three"),
        correctIndex = 3,
        explanation = "Teacher Anna mengatakan: 'I have three bananas.' Jadi jumlahnya tiga."
    ),
    // Reading
    ReadingQuestion(
        id = "kids_l1_read_1",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_1,
        passageTitle = "My Family",
        passageText = "This is my mom. Her name is Sara.",
        questionText = "Who is Sara?",
        options = listOf("My mom", "My sister", "My teacher", "My friend"),
        correctIndex = 0,
        explanation = "Teks menyebutkan: 'This is my mom. Her name is Sara.' Jadi Sara adalah ibu."
    ),
    ReadingQuestion(
        id = "kids_l1_read_2",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_1,
        passageTitle = "At the Farm",
        passageText = "I see a cow. The cow is big.",
        questionText = "What animal is big?",
        options = listOf("The dog", "The bird", "The cow", "The fish"),
        correctIndex = 2,
        explanation = "Teks menyebutkan: 'I see a cow. The cow is big.' Jadi hewan yang besar adalah sapi."
    ),
    // Speaking
    SpeakingQuestion(
        id = "kids_l1_speak_1",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_1,
        title = "My Favorite Fruit",
        context = "Ucapkan kalimat tentang buah kesukaanmu.",
        targetSentence = "I like red apples.",
        tip = "Ucapkan 'apples' dengan bunyi 'a' pendek seperti 'e' terbuka: 'EP-pels'."
    ),
    SpeakingQuestion(
        id = "kids_l1_speak_2",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_1,
        title = "My Pet Dog",
        context = "Ucapkan kalimat tentang hewan peliharaanmu.",
        targetSentence = "I have a big dog.",
        tip = "Bunyi 'h' pada 'have' diucapkan dengan hembusan napas, dan 'g' di akhir 'big' dan 'dog' harus terdengar jelas."
    ),

    // ===== LEVEL 2 =====
    // Listening
    ListeningQuestion(
        id = "kids_l2_listen_1",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_2,
        audioTitle = "Lily's Morning",
        audioSpeaker = "Lily",
        audioScript = "I wake up at six o'clock every day. I eat bread and drink milk. Then I walk to school with my brother.",
        questionText = "How does Lily go to school?",
        options = listOf("By bus", "By car", "She walks", "By bike"),
        correctIndex = 2,
        explanation = "Lily mengatakan: 'Then I walk to school with my brother.' Jadi dia berjalan kaki ke sekolah."
    ),
    ListeningQuestion(
        id = "kids_l2_listen_2",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_2,
        audioTitle = "In My Bag",
        audioSpeaker = "Ben",
        audioScript = "My school bag is blue. I have two books, a pencil, and a ruler in my bag. I do not have an eraser.",
        questionText = "Which thing is NOT in Ben's bag?",
        options = listOf("An eraser", "A pencil", "A ruler", "A book"),
        correctIndex = 0,
        explanation = "Ben mengatakan: 'I do not have an eraser.' Jadi penghapus tidak ada di tasnya."
    ),
    // Reading
    ReadingQuestion(
        id = "kids_l2_read_1",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_2,
        passageTitle = "Mia Likes Sports",
        passageText = "Mia likes sports. She plays badminton every Saturday. She does not like swimming because the water is cold.",
        questionText = "What sport does Mia play every Saturday?",
        options = listOf("Swimming", "Football", "Basketball", "Badminton"),
        correctIndex = 3,
        explanation = "Teks menyebutkan: 'She plays badminton every Saturday.' Jadi Mia bermain bulu tangkis."
    ),
    ReadingQuestion(
        id = "kids_l2_read_2",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_2,
        passageTitle = "After School",
        passageText = "Rudi comes home at two o'clock. He eats lunch with his grandma. After that, he does his homework in his room.",
        questionText = "Who does Rudi eat lunch with?",
        options = listOf("His mom", "His grandma", "His friend", "His teacher"),
        correctIndex = 1,
        explanation = "Teks menyebutkan: 'He eats lunch with his grandma.' Jadi Rudi makan siang bersama neneknya."
    ),
    // Speaking
    SpeakingQuestion(
        id = "kids_l2_speak_1",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_2,
        title = "Morning Routine",
        context = "Ucapkan kalimat tentang kegiatanmu setiap pagi.",
        targetSentence = "I brush my teeth every morning.",
        tip = "Untuk 'teeth', taruh ujung lidah di antara gigi saat mengucapkan bunyi 'th' di akhir kata."
    ),
    SpeakingQuestion(
        id = "kids_l2_speak_2",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_2,
        title = "Things I Don't Like",
        context = "Ucapkan kalimat tentang minuman yang tidak kamu sukai.",
        targetSentence = "I do not like cold milk.",
        tip = "Bunyi 'l' pada 'like', 'cold', dan 'milk' diucapkan dengan ujung lidah menyentuh langit-langit mulut."
    ),

    // ===== LEVEL 3 =====
    // Listening
    ListeningQuestion(
        id = "kids_l3_listen_1",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_3,
        audioTitle = "A Day at the Beach",
        audioSpeaker = "Nina",
        audioScript = "Last Sunday, my family went to the beach. My dad and I built a big sandcastle. Then a wave came and broke it. We laughed and ate ice cream together.",
        questionText = "What happened to the sandcastle?",
        options = listOf("Nina's dad took it home", "A dog jumped on it", "A wave broke it", "It got bigger"),
        correctIndex = 2,
        explanation = "Nina mengatakan: 'Then a wave came and broke it.' Jadi istana pasirnya rusak karena ombak."
    ),
    ListeningQuestion(
        id = "kids_l3_listen_2",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_3,
        audioTitle = "Lost Pencil Case",
        audioSpeaker = "Sam and Kevin",
        audioScript = "Hi Kevin, did you see my pencil case? Yes, Sam. I saw it under your chair this morning. Oh, thank you. I looked for it in my bag before.",
        questionText = "Where was Sam's pencil case?",
        options = listOf("In his bag", "On the teacher's desk", "In the library", "Under his chair"),
        correctIndex = 3,
        explanation = "Kevin mengatakan: 'I saw it under your chair this morning.' Jadi kotak pensilnya ada di bawah kursi Sam."
    ),
    // Reading
    ReadingQuestion(
        id = "kids_l3_read_1",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_3,
        passageTitle = "The Little Bird",
        passageText = "Yesterday, Dina found a little bird in her garden. The bird could not fly because its wing was hurt. Dina gave it some water and a small box. Her mother called an animal doctor. Two weeks later, the bird flew away happily.",
        questionText = "Why could the bird not fly?",
        options = listOf("Its wing was hurt", "It was too small", "It was hungry", "It was sleeping"),
        correctIndex = 0,
        explanation = "Teks menyebutkan: 'The bird could not fly because its wing was hurt.' Jadi sayapnya terluka."
    ),
    ReadingQuestion(
        id = "kids_l3_read_2",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_3,
        passageTitle = "Talking About the Weekend",
        passageText = "Andi: What did you do on Saturday, Rina? Rina: I visited my grandpa in the village. Andi: Did you see any animals? Rina: Yes, I fed his chickens and rode a horse. Andi: Wow, that sounds fun!",
        questionText = "What did Rina do in the village?",
        options = listOf("She swam in a river", "She fed chickens and rode a horse", "She played football with Andi", "She bought a new horse"),
        correctIndex = 1,
        explanation = "Rina mengatakan: 'I fed his chickens and rode a horse.' Jadi dia memberi makan ayam dan menunggang kuda."
    ),
    // Speaking
    SpeakingQuestion(
        id = "kids_l3_speak_1",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_3,
        title = "Yesterday's Fun",
        context = "Ceritakan apa yang kamu lakukan kemarin bersama teman-temanmu.",
        targetSentence = "Yesterday I played football with my friends.",
        tip = "Akhiran '-ed' pada 'played' dibaca seperti bunyi 'd' yang lembut: 'pleid', bukan 'play-ed'."
    ),
    SpeakingQuestion(
        id = "kids_l3_speak_2",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_3,
        title = "A Trip to the Zoo",
        context = "Ceritakan perjalananmu ke kebun binatang hari Minggu lalu.",
        targetSentence = "We went to the zoo last Sunday.",
        tip = "Bunyi 'z' pada 'zoo' bergetar seperti suara lebah 'zzz', dan 'oo' dibaca panjang: 'zuu'."
    ),

    // ===== LEVEL 4 =====
    // Listening
    ListeningQuestion(
        id = "kids_l4_listen_1",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_4,
        audioTitle = "Choosing a Pet",
        audioSpeaker = "Teacher Anna",
        audioScript = "Leo wanted a new pet. His sister wanted a rabbit, but Leo wanted a turtle. He said a turtle is quieter than a rabbit and it lives longer. In the end, their parents bought a turtle because it needs less space in their small apartment.",
        questionText = "Why did the parents buy a turtle?",
        options = listOf("It was cheaper than a rabbit", "Leo's sister wanted it", "It was faster than a rabbit", "It needs less space in their apartment"),
        correctIndex = 3,
        explanation = "Audio menyebutkan: 'their parents bought a turtle because it needs less space in their small apartment.' Jadi alasannya karena kura-kura butuh tempat lebih sedikit."
    ),
    ListeningQuestion(
        id = "kids_l4_listen_2",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_4,
        audioTitle = "The School Race",
        audioSpeaker = "Coach Mike",
        audioScript = "Today we had a running race at school. Jake was faster than Tim, but Emma was the fastest of all. Tim fell down at the start, so he finished last. Everyone clapped for him because he did not give up.",
        questionText = "Who won the race?",
        options = listOf("Jake", "Emma", "Tim", "Coach Mike"),
        correctIndex = 1,
        explanation = "Coach Mike mengatakan: 'Emma was the fastest of all.' Jadi Emma yang memenangkan lomba."
    ),
    // Reading
    ReadingQuestion(
        id = "kids_l4_read_1",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_4,
        passageTitle = "The Rainy Day Picnic",
        passageText = "Maya and her family planned a picnic in the park. In the morning, the sky was dark and grey. Maya's father looked outside and took the big umbrellas from the cupboard. When they arrived at the park, it started to rain. Luckily, they found a small roof near the lake and ate their sandwiches there. Maya said it was the funniest picnic ever.",
        questionText = "Why did Maya's father take the umbrellas?",
        options = listOf("He wanted to sell them", "The sun was very hot", "He thought it might rain", "Maya asked him to"),
        correctIndex = 2,
        explanation = "Teks menyebutkan: 'the sky was dark and grey' lalu ayahnya mengambil payung. Langit gelap menunjukkan ia mengira akan turun hujan."
    ),
    ReadingQuestion(
        id = "kids_l4_read_2",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_4,
        passageTitle = "Two Brothers",
        passageText = "Adam and Bilal are brothers. Adam is twelve, and Bilal is nine. Adam is taller than Bilal, but Bilal is better at drawing. Every evening, Adam helps Bilal with math because math is difficult for him. In return, Bilal draws pictures for Adam's school projects. They are a great team.",
        questionText = "What can we learn about Adam and Bilal?",
        options = listOf("They help each other", "They do not like school", "Bilal is older than Adam", "Adam is better at drawing"),
        correctIndex = 0,
        explanation = "Teks menyebutkan: 'Adam helps Bilal with math' dan 'Bilal draws pictures for Adam's school projects.' Jadi mereka saling membantu."
    ),
    // Speaking
    SpeakingQuestion(
        id = "kids_l4_speak_1",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_4,
        title = "Cats or Dogs",
        context = "Bandingkan dua hewan dan sebutkan alasanmu memilih salah satunya.",
        targetSentence = "I like cats more than dogs because they are quiet.",
        tip = "Pada 'than' dan 'they', bunyi 'th' diucapkan dengan lidah di antara gigi dan bergetar, bukan seperti 'd'."
    ),
    SpeakingQuestion(
        id = "kids_l4_speak_2",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_4,
        title = "Me and My Sister",
        context = "Bandingkan dirimu dengan saudaramu menggunakan kata pembanding.",
        targetSentence = "My sister is taller than me, but I run faster.",
        tip = "Akhiran '-er' pada 'taller' dan 'faster' dibaca lemah dan pendek: 'TO-ler', 'FES-ter'."
    ),

    // ===== LEVEL 5 =====
    // Listening
    ListeningQuestion(
        id = "kids_l5_listen_1",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_5,
        audioTitle = "Amazing Elephants",
        audioSpeaker = "Teacher Anna",
        audioScript = "Elephants are the largest land animals in the world. They use their long trunks to drink water, pick up food, and even say hello to each other. Elephants have a very good memory, and they can remember places with water for many years. Sadly, some elephants are in danger because people cut down the forests where they live. If we protect their homes, elephants will have a safer future.",
        questionText = "According to the speaker, what will help elephants have a safer future?",
        options = listOf("Giving them more toys", "Protecting their homes", "Teaching them to swim", "Moving them to the city"),
        correctIndex = 1,
        explanation = "Teacher Anna mengatakan: 'If we protect their homes, elephants will have a safer future.' Jadi melindungi habitat gajah akan membantu mereka."
    ),
    ListeningQuestion(
        id = "kids_l5_listen_2",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_5,
        audioTitle = "Our Class Garden",
        audioSpeaker = "Principal Lee",
        audioScript = "Next month, our school will start a class garden. Each class will grow vegetables like tomatoes, carrots, and spinach. Students will water the plants every morning before lessons begin. If the garden grows well, we will cook the vegetables and share a healthy lunch in June. We hope this project will teach you to work together and take care of nature.",
        questionText = "What will happen if the garden grows well?",
        options = listOf("Students will sell the vegetables", "The school will close in June", "Students will get a holiday", "Everyone will share a healthy lunch"),
        correctIndex = 3,
        explanation = "Principal Lee mengatakan: 'If the garden grows well, we will cook the vegetables and share a healthy lunch in June.' Jadi semua akan makan siang sehat bersama."
    ),
    // Reading
    ReadingQuestion(
        id = "kids_l5_read_1",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_5,
        passageTitle = "The Red Planet",
        passageText = "Mars is the fourth planet from the Sun. People call it the Red Planet because its soil has a lot of rusty iron, which makes it look red. Mars is much colder than Earth, and its air is too thin for humans to breathe. Scientists have sent robots called rovers to explore its surface. These rovers take photos and study rocks to learn whether there was water on Mars long ago. In the future, astronauts may travel to Mars, but they will need special suits and homes to survive.",
        questionText = "In the text, the word 'explore' is closest in meaning to...",
        options = listOf("To destroy", "To clean", "To travel and learn about", "To build houses on"),
        correctIndex = 2,
        explanation = "Teks menyebutkan robot dikirim 'to explore its surface' lalu 'take photos and study rocks'. Jadi 'explore' berarti menjelajahi dan mempelajari."
    ),
    ReadingQuestion(
        id = "kids_l5_read_2",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_5,
        passageTitle = "Plastic in the Ocean",
        passageText = "Every year, millions of plastic bottles and bags end up in the ocean. Sea turtles sometimes think floating plastic bags are jellyfish, which they like to eat. When they eat the plastic, they can get very sick. Plastic also breaks into tiny pieces that fish swallow by mistake. If people use reusable bottles and bags, there will be less plastic in the sea. Many children around the world now join beach clean-up days to help. Small actions can make a big difference.",
        questionText = "Why do sea turtles eat plastic bags?",
        options = listOf("They look like jellyfish", "They taste sweet", "They are very colorful", "Turtles need plastic to grow"),
        correctIndex = 0,
        explanation = "Teks menyebutkan: 'Sea turtles sometimes think floating plastic bags are jellyfish, which they like to eat.' Jadi penyu mengira kantong plastik adalah ubur-ubur."
    ),
    // Speaking
    SpeakingQuestion(
        id = "kids_l5_speak_1",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_5,
        title = "Rainy Day Plans",
        context = "Ucapkan rencanamu jika besok turun hujan.",
        targetSentence = "If it rains tomorrow, we will stay at home and play games.",
        tip = "Beri jeda singkat setelah 'tomorrow', dan ucapkan 'will' dengan bunyi 'w' yang membulatkan bibir."
    ),
    SpeakingQuestion(
        id = "kids_l5_speak_2",
        category = TestCategory.KIDS,
        level = DifficultyLevel.LEVEL_5,
        title = "Save Water",
        context = "Ucapkan alasan mengapa kita harus menghemat air.",
        targetSentence = "We should save water because many animals and plants need it to live.",
        tip = "Bedakan bunyi 'v' pada 'save' dan 'live' (gigi atas menyentuh bibir bawah) dengan bunyi 'f'."
    )
)
