(ns passman.app
  (:require [clojure.tools.cli :refer [parse-opts]]
            [passman.db :refer [list-passwords]]
            [table.core :as t]))

(def cli-options
  [[nil "--list"]])

(defn -main [& args]
  (let [parsed-options (parse-opts args cli-options)
        options (:options parsed-options)]
    (cond
      (:list options) (t/table (list-passwords)))))

