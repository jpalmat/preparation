package hackerRank.interviewpreparationkit.arrays.newyearchaos;

import java.util.Arrays;

public class NewYearChaos {
    public static void main(String[] args) {
        minimumBribes(new int[]{1, 3, 2, 6, 4, 8, 9, 7, 5, 10, 13, 12, 11, 15, 14, 18, 16, 20, 19, 17, 22, 23, 21, 25, 24, 28, 27, 26, 30, 29, 31, 32, 34, 33, 35, 37, 39, 38, 36, 41, 40, 42, 43, 46, 44, 47, 45, 50, 51, 49, 52, 48, 54, 53, 55, 56, 57, 58, 61, 59, 63, 60, 62, 66, 64, 65, 69, 70, 67, 68, 73, 72, 71, 75, 77, 74, 76, 79, 78, 80, 82, 83, 84, 81, 86, 88, 87, 85, 90, 89, 93, 91, 95, 92, 96, 94, 97, 98, 99, 102, 100, 101, 104, 106, 103, 105, 107, 110, 111, 109, 113, 108, 112, 115, 114, 117, 116, 120, 118, 119, 121, 123, 125, 122, 126, 124, 128, 127, 130, 129, 133, 131, 132, 134, 137, 136, 135, 139, 141, 138, 143, 140, 144, 142, 147, 146, 145, 148, 149, 150, 152, 151, 155, 153, 157, 156, 154, 160, 158, 159, 163, 161, 162, 164, 165, 168, 166, 167, 170, 169, 171, 172, 175, 174, 173, 177, 176, 178, 180, 181, 179, 182, 184, 183, 185, 187, 188, 186, 189, 191, 192, 190, 194, 195, 193, 196, 197, 199, 198, 200, 203, 201, 202, 205, 207, 204, 209, 208, 206, 212, 210, 213, 211, 214, 217, 216, 215, 219, 221, 218, 223, 220, 225, 222, 226, 227, 224, 229, 228, 231, 230, 234, 232, 235, 233, 238, 236, 240, 237, 241, 239, 242, 244, 243, 246, 245, 249, 248, 247, 251, 250, 253, 255, 252, 254, 258, 256, 259, 261, 260, 257, 262, 265, 263, 264, 268, 266, 270, 267, 269, 272, 271, 273, 275, 276, 274, 277, 279, 281, 278, 283, 280, 284, 282, 285, 287, 286, 290, 288, 289, 291, 293, 292, 294, 297, 295, 296, 300, 301, 299, 298, 304, 302, 303, 307, 308, 305, 306, 309, 311, 310, 314, 313, 312, 315, 318, 316, 319, 317, 321, 320, 324, 322, 325, 327, 323, 326, 330, 329, 332, 328, 331, 333, 336, 335, 334, 338, 337, 340, 341, 339, 343, 345, 342, 346, 348, 344, 347, 349, 352, 351, 350, 353, 355, 354, 358, 357, 356, 360, 359, 361, 362, 365, 364, 363, 367, 366, 369, 368, 371, 370, 374, 372, 376, 373, 375, 378, 377, 381, 379, 380, 382, 384, 383, 386, 385, 388, 387, 389, 392, 390, 391, 395, 394, 393, 398, 397, 396, 399, 402, 400, 401, 404, 403, 407, 405, 406, 410, 408, 412, 409, 411, 413, 416, 415, 414, 418, 417, 420, 421, 419, 422, 423, 425, 427, 424, 429, 426, 431, 428, 432, 430, 435, 433, 436, 434, 438, 437, 439, 440, 442, 444, 441, 443, 445, 447, 446, 449, 448, 451, 453, 452, 450, 454, 457, 455, 459, 456, 461, 458, 463, 462, 460, 465, 467, 464, 468, 466, 470, 471, 469, 472, 473, 476, 475, 477, 478, 474, 480, 481, 479, 484, 483, 485, 482, 487, 486, 490, 488, 492, 489, 491, 494, 493, 496, 498, 495, 500, 497, 501, 499, 503, 502, 505, 506, 504, 507, 508, 511, 512, 510, 509, 513, 516, 514, 515, 517, 518, 520, 522, 519, 523, 525, 521, 524, 526, 529, 527, 531, 530, 533, 528, 532, 536, 537, 535, 538, 534, 540, 539, 542, 541, 543, 545, 544, 546, 549, 548, 551, 547, 550, 552, 554, 553, 556, 555, 558, 560, 557, 561, 563, 559, 565, 562, 564, 567, 566, 569, 568, 571, 573, 570, 572, 575, 574, 576, 579, 578, 577, 581, 582, 583, 580, 585, 584, 588, 589, 586, 587, 591, 590, 592, 595, 593, 594, 596, 598, 597, 600, 599, 603, 602, 604, 601, 607, 605, 609, 606, 608, 611, 610, 612, 615, 613, 614, 617, 616, 619, 618, 620, 622, 624, 621, 623, 625, 627, 626, 630, 629, 628, 632, 631, 634, 633, 636, 635, 637, 639, 638, 640, 642, 641, 645, 644, 643, 648, 646, 649, 647, 652, 651, 650, 654, 653, 656, 657, 659, 655, 660, 661, 663, 658, 664, 662, 667, 666, 669, 668, 665, 671, 672, 670, 673, 675, 677, 674, 676, 678, 681, 680, 679, 684, 682, 685, 686, 687, 688, 683, 690, 691, 693, 689, 692, 695, 694, 697, 696, 700, 699, 698, 701, 703, 702, 705, 704, 707, 706, 708, 710, 709, 713, 711, 712, 715, 714, 717, 716, 719, 720, 718, 722, 721, 724, 726, 725, 727, 729, 723, 731, 732, 728, 734, 730, 733, 737, 735, 738, 740, 741, 736, 739, 744, 743, 746, 747, 742, 745, 748, 751, 750, 752, 749, 753, 754, 756, 755, 759, 760, 761, 757, 758, 763, 762, 766, 765, 764, 769, 768, 770, 767, 773, 772, 771, 776, 777, 774, 778, 775, 780, 779, 781, 783, 782, 785, 784, 788, 786, 787, 789, 791, 790, 793, 794, 795, 792, 798, 796, 799, 797, 802, 801, 800, 804, 803, 806, 805, 809, 808, 807, 812, 813, 811, 815, 814, 810, 818, 816, 819, 817, 820, 821, 822, 825, 823, 824, 828, 827, 826, 829, 831, 830, 834, 832, 833, 836, 838, 839, 837, 835, 840, 842, 841, 843, 845, 846, 844, 849, 848, 847, 851, 850, 854, 852, 856, 855, 853, 858, 857, 859, 862, 860, 864, 865, 861, 866, 863, 867, 870, 868, 871, 872, 869, 873, 875, 874, 878, 876, 879, 880, 877, 883, 881, 885, 882, 884, 887, 886, 890, 888, 892, 891, 889, 893, 894, 895, 896, 897, 900, 899, 898, 901, 902, 903, 904, 906, 905, 909, 907, 911, 910, 908, 913, 912, 916, 915, 914, 918, 917, 920, 919, 922, 921, 925, 924, 923, 927, 926, 930, 928, 929, 932, 933, 931, 934, 935, 936, 937, 940, 938, 939, 942, 941, 945, 943, 947, 944, 949, 946, 948, 952, 951, 954, 950, 955, 953, 956, 958, 957, 961, 959, 960, 963, 962, 966, 965, 964, 969, 968, 971, 967, 973, 972, 970, 974, 975, 976, 979, 978, 981, 977, 980, 984, 983, 982, 985, 987, 986, 989, 988, 992, 993, 990, 994, 991, 995, 996, 997});
        /*
        1, 3, 2, 6, 4, 8, 9, 7, 5, 10, 13, 12, 11, 15, 14, 18, 16, 20, 19, 17, 22, 23, 21, 25, 24, 28, 27, 26, 30, 29, 31, 32, 34, 33, 35, 37, 39, 38, 36, 41, 40, 42, 43, 46, 44, 47, 45, 50, 51, 49, 52, 48, 54, 53, 55, 56, 57, 58, 61, 59, 63, 60, 62, 66, 64, 65, 69, 70, 67, 68, 73, 72, 71, 75, 77, 74, 76, 79, 78, 80, 82, 83, 84, 81, 86, 88, 87, 85, 90, 89, 93, 91, 95, 92, 96, 94, 97, 98, 99, 102, 100, 101, 104, 106, 103, 105, 107, 110, 111, 109, 113, 108, 112, 115, 114, 117, 116, 120, 118, 119, 121, 123, 125, 122, 126, 124, 128, 127, 130, 129, 133, 131, 132, 134, 137, 136, 135, 139, 141, 138, 143, 140, 144, 142, 147, 146, 145, 148, 149, 150, 152, 151, 155, 153, 157, 156, 154, 160, 158, 159, 163, 161, 162, 164, 165, 168, 166, 167, 170, 169, 171, 172, 175, 174, 173, 177, 176, 178, 180, 181, 179, 182, 184, 183, 185, 187, 188, 186, 189, 191, 192, 190, 194, 195, 193, 196, 197, 199, 198, 200, 203, 201, 202, 205, 207, 204, 209, 208, 206, 212, 210, 213, 211, 214, 217, 216, 215, 219, 221, 218, 223, 220, 225, 222, 226, 227, 224, 229, 228, 231, 230, 234, 232, 235, 233, 238, 236, 240, 237, 241, 239, 242, 244, 243, 246, 245, 249, 248, 247, 251, 250, 253, 255, 252, 254, 258, 256, 259, 261, 260, 257, 262, 265, 263, 264, 268, 266, 270, 267, 269, 272, 271, 273, 275, 276, 274, 277, 279, 281, 278, 283, 280, 284, 282, 285, 287, 286, 290, 288, 289, 291, 293, 292, 294, 297, 295, 296, 300, 301, 299, 298, 304, 302, 303, 307, 308, 305, 306, 309, 311, 310, 314, 313, 312, 315, 318, 316, 319, 317, 321, 320, 324, 322, 325, 327, 323, 326, 330, 329, 332, 328, 331, 333, 336, 335, 334, 338, 337, 340, 341, 339, 343, 345, 342, 346, 348, 344, 347, 349, 352, 351, 350, 353, 355, 354, 358, 357, 356, 360, 359, 361, 362, 365, 364, 363, 367, 366, 369, 368, 371, 370, 374, 372, 376, 373, 375, 378, 377, 381, 379, 380, 382, 384, 383, 386, 385, 388, 387, 389, 392, 390, 391, 395, 394, 393, 398, 397, 396, 399, 402, 400, 401, 404, 403, 407, 405, 406, 410, 408, 412, 409, 411, 413, 416, 415, 414, 418, 417, 420, 421, 419, 422, 423, 425, 427, 424, 429, 426, 431, 428, 432, 430, 435, 433, 436, 434, 438, 437, 439, 440, 442, 444, 441, 443, 445, 447, 446, 449, 448, 451, 453, 452, 450, 454, 457, 455, 459, 456, 461, 458, 463, 462, 460, 465, 467, 464, 468, 466, 470, 471, 469, 472, 473, 476, 475, 477, 478, 474, 480, 481, 479, 484, 483, 485, 482, 487, 486, 490, 488, 492, 489, 491, 494, 493, 496, 498, 495, 500, 497, 501, 499, 503, 502, 505, 506, 504, 507, 508, 511, 512, 510, 509, 513, 516, 514, 515, 517, 518, 520, 522, 519, 523, 525, 521, 524, 526, 529, 527, 531, 530, 533, 528, 532, 536, 537, 535, 538, 534, 540, 539, 542, 541, 543, 545, 544, 546, 549, 548, 551, 547, 550, 552, 554, 553, 556, 555, 558, 560, 557, 561, 563, 559, 565, 562, 564, 567, 566, 569, 568, 571, 573, 570, 572, 575, 574, 576, 579, 578, 577, 581, 582, 583, 580, 585, 584, 588, 589, 586, 587, 591, 590, 592, 595, 593, 594, 596, 598, 597, 600, 599, 603, 602, 604, 601, 607, 605, 609, 606, 608, 611, 610, 612, 615, 613, 614, 617, 616, 619, 618, 620, 622, 624, 621, 623, 625, 627, 626, 630, 629, 628, 632, 631, 634, 633, 636, 635, 637, 639, 638, 640, 642, 641, 645, 644, 643, 648, 646, 649, 647, 652, 651, 650, 654, 653, 656, 657, 659, 655, 660, 661, 663, 658, 664, 662, 667, 666, 669, 668, 665, 671, 672, 670, 673, 675, 677, 674, 676, 678, 681, 680, 679, 684, 682, 685, 686, 687, 688, 683, 690, 691, 693, 689, 692, 695, 694, 697, 696, 700, 699, 698, 701, 703, 702, 705, 704, 707, 706, 708, 710, 709, 713, 711, 712, 715, 714, 717, 716, 719, 720, 718, 722, 721, 724, 726, 725, 727, 729, 723, 731, 732, 728, 734, 730, 733, 737, 735, 738, 740, 741, 736, 739, 744, 743, 746, 747, 742, 745, 748, 751, 750, 752, 749, 753, 754, 756, 755, 759, 760, 761, 757, 758, 763, 762, 766, 765, 764, 769, 768, 770, 767, 773, 772, 771, 776, 777, 774, 778, 775, 780, 779, 781, 783, 782, 785, 784, 788, 786, 787, 789, 791, 790, 793, 794, 795, 792, 798, 796, 799, 797, 802, 801, 800, 804, 803, 806, 805, 809, 808, 807, 812, 813, 811, 815, 814, 810, 818, 816, 819, 817, 820, 821, 822, 825, 823, 824, 828, 827, 826, 829, 831, 830, 834, 832, 833, 836, 838, 839, 837, 835, 840, 842, 841, 843, 845, 846, 844, 849, 848, 847, 851, 850, 854, 852, 856, 855, 853, 858, 857, 859, 862, 860, 864, 865, 861, 866, 863, 867, 870, 868, 871, 872, 869, 873, 875, 874, 878, 876, 879, 880, 877, 883, 881, 885, 882, 884, 887, 886, 890, 888, 892, 891, 889, 893, 894, 895, 896, 897, 900, 899, 898, 901, 902, 903, 904, 906, 905, 909, 907, 911, 910, 908, 913, 912, 916, 915, 914, 918, 917, 920, 919, 922, 921, 925, 924, 923, 927, 926, 930, 928, 929, 932, 933, 931, 934, 935, 936, 937, 940, 938, 939, 942, 941, 945, 943, 947, 944, 949, 946, 948, 952, 951, 954, 950, 955, 953, 956, 958, 957, 961, 959, 960, 963, 962, 966, 965, 964, 969, 968, 971, 967, 973, 972, 970, 974, 975, 976, 979, 978, 981, 977, 980, 984, 983, 982, 985, 987, 986, 989, 988, 992, 993, 990, 994, 991, 995, 996, 997
        5=2
        7=2
        8=2
        6=1

i=3 6 - i = 3
i=4 6 - i = 2
        12345678

        12354678
        12534678
        12534768
        12537468
        12537486
        12537846
        12537864
         */
    }

    static void minimumBribes(int[] q) {
//        int swap = 0;
//        boolean print = true;
//        int[] newArray;
//        int minorNumber = 0;
//        for(int i=0; i < q.length; i++) {
//            if(q[i]==i+1) {
//                int startI = i;
//                int finali = q.length - i > 10 ? 10 : q.length;
//                minorNumber = (int) Arrays.stream(q).skip(startI).limit(finali).filter(x -> x < q[startI]).count();
//                if (minorNumber > 2) {
//                    System.out.println("Too chaotic");
//                    print = false;
//                    break;
//                } else if(minorNumber>0){
//                    swap += minorNumber;
//                }
//            }
//            if(q[i]-1-i>2) {
//                System.out.println("Too chaotic");
//                print = false;
//                break;
//            } else if(q[i]>i){
//                if(q[i]-1-i!=0) {
//                    swap+=q[i]-1-i;
//                }
//            } else {
//                int startI = i;
//                int finali = q.length - i > 10 ? 10 : q.length;
//                minorNumber = (int) Arrays.stream(q).skip(startI).limit(finali).filter(x -> x < q[startI]).count();
//                if (minorNumber > 2) {
//                    System.out.println("Too chaotic");
//                    print = false;
//                    break;
//                } else if(minorNumber>0){
//                    swap += minorNumber;
//                }
//            }
//        }
//        if(print)
//            System.out.println(swap);
        int temp = 0;
        int BribesCount = 0;
        Boolean flag = true;
        for (int i = q.length-1; i >=0; --i) {
            if(q[i] != i+1) {
                if (i>=2&&q[i - 2] == i + 1 ) {
                    BribesCount++;
                    temp=q[i-2];
                    q[i-2]=q[i-1];
                    q[i-1]=temp;
                } if( i>=1&&q[i - 1] == i + 1){
                    BribesCount++;
                    temp=q[i-1];
                    q[i-1]=q[i];
                    q[i]=temp;
                }
                else {
                    System.out.println("Too chaotic");
                    flag = false;
                    break;
                }
            }
        }
        if(flag == true)
            System.out.println(BribesCount);
    }
}
