import Foundation

@objc public class CheckVpn: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
