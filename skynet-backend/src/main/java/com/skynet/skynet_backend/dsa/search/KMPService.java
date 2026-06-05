package com.skynet.skynet_backend.dsa.search;

import com.skynet.skynet_backend.dto.SearchResultDTO;
import com.skynet.skynet_backend.entity.Passenger;
import com.skynet.skynet_backend.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KMPService {

    private final PassengerRepository passengerRepository;

    public SearchResultDTO search(String pattern) {

        long start =
                System.currentTimeMillis();

        int matches = 0;

        for (Passenger passenger :
                passengerRepository.findAll()) {

            if (kmpSearch(
                    passenger.getName(),
                    pattern
            )) {

                matches++;
            }
        }

        long end =
                System.currentTimeMillis();

        return new SearchResultDTO(
                pattern,
                matches,
                end - start
        );
    }

    private boolean kmpSearch(
            String text,
            String pattern
    ) {

        int[] lps =
                computeLPS(pattern);

        int i = 0;
        int j = 0;

        while (i < text.length()) {

            if (pattern.charAt(j)
                    == text.charAt(i)) {

                i++;
                j++;
            }

            if (j == pattern.length()) {

                return true;
            }

            else if (
                    i < text.length()
                            && pattern.charAt(j)
                            != text.charAt(i)
            ) {

                if (j != 0) {

                    j = lps[j - 1];

                } else {

                    i++;
                }
            }
        }

        return false;
    }

    private int[] computeLPS(
            String pattern
    ) {

        int[] lps =
                new int[pattern.length()];

        int len = 0;
        int i = 1;

        while (i < pattern.length()) {

            if (pattern.charAt(i)
                    == pattern.charAt(len)) {

                len++;

                lps[i] = len;

                i++;

            } else {

                if (len != 0) {

                    len = lps[len - 1];

                } else {

                    lps[i] = 0;

                    i++;
                }
            }
        }

        return lps;
    }
}
