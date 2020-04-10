(ns stock-options.returns.shared)

(defn losses
  [option]
  (- (:premium option)))

(defn shift-price
  [option percentage]
  (* (:current option) (+ 1 percentage)))
