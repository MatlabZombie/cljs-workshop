(ns cljsworkshop.core
  (:require [goog.events :as events]
            [goog.dom :as dom]
            [cljsworkshop.geocoder/geocode :as geocode]))

(def *map* nil)

(def my-opts
   {:zoom 3
    :mapTypeId google.maps.MapTypeId.ROADMAP
    :center (google.maps.LatLng. 29, 66)})
   
(defn- search-for [search-term]
      (.log js/console (str "Searching for " search-term))
      (geocode))

(defn- map-load []
  (let [elem (dom/getElement "map-canvas")]
     (set! *map* (google.maps.Map. elem (clj->js my-opts)))))

(defn main []
  (let [counter (atom 0)
        search-button  (dom/getElement "input-button")
        search-box (dom/getElement "search-display")]
 

    (events/listen 
      js/window 
      "load" 
      map-load)


    (events/listen 
        search-button 
        "click"
        (fn [event] (search-for (.-value search-box))))


    (events/listen
      search-box
      "keypress"
        (fn [event] 
          (let [key-pressed (.-charCode event)
               enter-key (js/parseInt 13)]
               (if 
                (== enter-key key-pressed)
                (search-for (.-value search-box))))))))
    
(main)














