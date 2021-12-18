(ns leetcode.0005-longest-palindrome)

(defn longest-palindrome [s]
  (letfn [(center->palindrome [st ed]
            (if (or
                 (neg? st)
                 (= ed (count s))
                 (not= (.charAt s st) (.charAt s ed)))
              (subs s (inc st) ed)
              (recur (dec st) (inc ed))))]
    (transduce
     (map (partial apply center->palindrome))
     (partial max-key count)
     ""
     (cons
      [0 0]
      (interleave
       (partition 2 1 (range 0 (count s)))
       (map #(vector % %) (range 1 (count s))))))))

(longest-palindrome "saippuakivikauppias")