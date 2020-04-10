(ns stock-options.labeling.vectors)

(def labels
  [:ticker :current :type :strike :expiry :premium])

(defn label-option
  [option]
  (zipmap labels option))

(defn label-options
  [options]
  (map label-option options))
