(ns passman.db
  (:require [babashka.pods :as pods]
            [honey.sql :as sql]
            [honey.sql.helpers :as h]
            [babashka.fs :as fs]))

(pods/load-pod 'org.babashka/go-sqlite3 "0.1.0")

(require '[pod.babashka.go-sqlite3 :as sqlite])

(def dbname "passman.db")

(defn create-db! []
  (when (not (fs/exists? dbname))
    (sqlite/execute! dbname
                     (-> (h/create-table :password)
                         (h/with-columns [[:url :text]
                                          [:username :text]
                                          [[:unique nil :url :username]]])
                         (sql/format)))))


(comment
  (create-db!))