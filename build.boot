(set-env! :source-paths   #{"src"}
          :resource-paths #{"resources"}
          :dependencies   '[[org.clojure/clojurescript "1.9.562"]
                            [quil "2.6.0"]

                            [org.clojure/clojure "1.9.0-alpha17" :scope "test"]
                            [adzerk/boot-cljs "2.0.0" :scope "test"]]
          :exclusions     '[org.clojure/clojure
                            org.clojure/clojurescript])

(require '[adzerk.boot-cljs :refer [cljs]])

(task-options!
 target {:dir #{"target"}})

(deftask build
  "Compile and bundle sketch to target directory."
  []
  (comp
   (cljs :optimizations :advanced
         :compiler-options {:output-wrapper true})
   (sift :include #{#"\.out/" #"\.edn$"}
         :invert true)
   (target)))
