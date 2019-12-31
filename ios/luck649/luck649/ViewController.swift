//
//  ViewController.swift
//  luck649
//
//  Created by Chi Wang on 12/28/19.
//  Copyright © 2019 Chi Wang. All rights reserved.
//

import UIKit
import WebKit

class ViewController: UIViewController {

    @IBOutlet weak var mWebKit: WKWebView!
    
    let url = URL(string: "https://txproxy.9lp.com/games/649.html")
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        let myRequest = URLRequest(url: url!)
        mWebKit.sizeToFit()
        mWebKit.load(myRequest)
    }

}

