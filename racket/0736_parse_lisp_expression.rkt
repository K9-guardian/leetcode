#lang racket

(define (evaluate expression)
  (define exprs (read (open-input-string expression)))
  ;; Store map of symbol -> value
  ;; Recursion will naturally take care of scope
  (define (eval-recur expr table)
    (match expr
      [(? integer? x) x]
      [(? symbol? s) (hash-ref table s)]
      [(list 'add x y) (+ (eval-recur x table) (eval-recur y table))]
      [(list 'mult x y) (* (eval-recur x table) (eval-recur y table))]
      [(list 'let binds ... expr)
       (for/fold ([table table]
                  #:result (eval-recur expr table))
                 ([pair (in-slice 2 (in-list binds))])
         (hash-set
          table
          (first pair)
          (eval-recur (second pair) table)))]))
  (eval-recur exprs #hasheq()))

(evaluate "(let a1 3 b2 (add a1 1) b2)")