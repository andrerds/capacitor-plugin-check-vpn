import { WebPlugin } from '@capacitor/core';

import type { CheckVpnPlugin } from './definitions';

export class CheckVpnWeb extends WebPlugin implements CheckVpnPlugin {
  async getVpnStatus(): Promise<{ vpnStatus: string | undefined }> {
        return { vpnStatus:  undefined };
  }
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
