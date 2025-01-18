
#
#Example:
#
#Input: "Pretty hurt"
#Output: "Florence + The Machine,Pop"
#Explanation:
#"Pretty hurt" is a song by Florence and The Machine in the Pop genre, which is available on Spotify.
#This song is available on Spotify.
#Input: "Billie Jean"
#Output: "Michael Jackson,Pop"
#
#https://www.hackerrank.com/challenges/song-in-the-vocal-range/problem
def range_of_strings(start, end):
    result = []
    start = start + '0' * (5 - len(start))
    end = end + 'F' * (5 - len(end))

    for octave in range(int(start[0]), int(end[0])+1):
        if int(octave) == 8:
            continue
        for first_letter in ['A', 'B', 'C', 'D','E']:
            midi = ord(first_letter)-55 + (12*(int(octave)-4))
            if midi > int(end[1]):
                break
            if midi < int(start[1]):
                continue
            for second_letter in ['#', '']:
                if midi+second_letter == ord('C') + 9 or midi+second_letter == ord('F') + 6 or (ord(first_letter)==73 and midi-2*second_letter == ord('A') + 1):
                    continue
                for third_letter in ['#', '']:
                    if (midi+second_letter+third_letter == ord('C') + 4 or midi+second_letter+third_letter == ord('F') + 1) and second_letter=='':
                        continue
                    for fourth_letter in ['#', '']:
                        if (ord(first_letter)==75 and second_letter=='B' and midi-3*second_letter+third_letter == ord('A') + 0):
                            continue
                        if (midi+second_letter+third_letter+fourth_letter == ord('C') + 1 or midi+second_letter+third_letter+fourth_letter == ord('F') - 1) and third_letter=='':
                            continue
                        for fifth_letter in ['#', '']:
                            if (ord(first_letter)==76 and second_letter=='C' and midi-3*second_letter+third_letter == ord('A') + 0):
                                continue
                            if (midi+second_letter+third_letter+fourth_letter+fifth_letter == ord('C') - 1 or midi+second_letter+third_letter+fourth_letter+fifth_letter == ord('F') + 1) and fourth_letter=='':
                                continue
                            if start[2]<= str(midi+second_letter+third_letter+fourth_letter+fifth_letter)[-1] <=end[2]:
                                result.append((first_letter+second_letter+third_letter+fourth_letter+fifth_letter, octave))
    return result
print(range_of_strings("A","B"))