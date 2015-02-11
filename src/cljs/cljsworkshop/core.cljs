(ns cljsworkshop.core
  (:require [goog.events :as events]
            [goog.dom :as dom]))

(def *map* nil)

(def my-opts
   {:zoom 3
    :mapTypeId google.maps.MapTypeId.ROADMAP
    :center (google.maps.LatLng. 29, 66)})
   

(defn- map-load []
  (let [elem (dom/getElement "map-canvas")]
     (set! *map* (google.maps.Map. elem (clj->js my-opts)))))

(defn main []
  (let [counter  (atom 0)
        search-button  (dom/getElement "input-button")
        display (dom/getElement "search-display")]
 
    ;; Assign an load event listener 
    (events/listen 
      js/window 
      "load" 
      map-load)

    ;; Assign button click event listener
    (events/listen 
        search-button 
        "click"
        (fn [event] 
          (let [search-term (.-value display)]
            (.log js/console (str "Searching for " search-term))
            )))))
    
(main)














