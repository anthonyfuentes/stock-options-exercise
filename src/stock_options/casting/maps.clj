(ns stock-options.casting.maps)

(defn ->double
  [value]
  (try (Double/parseDouble value)
       (catch Exception e)))

(defn ->long
  [value]
  (try (Long/parseLong value)
       (catch Exception e)))

(defn ->number
  [value]
  (cond
    (number? value) value
    (string? value) (or (->long value) (->double value))
    :else nil))

(def cast-map
  {
   :ticker str
   :current ->number
   :type keyword
   :strike ->number
   :expiry str
   :premium ->number
   })

(defn cast-values
  [casted-option [label value]]
  (assoc
    casted-option
    label
    ((label cast-map) value)))

(defn cast-option
  [option]
  (reduce cast-values {} option))

(defn cast-options
  [options]
  (map cast-option options))
